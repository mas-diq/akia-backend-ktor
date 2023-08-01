package com.masdiq.route.auth

import com.masdiq.util.EndPoint
import com.masdiq.model.auth.UserSession
import com.masdiq.repository.auth.UserDataInterface
import com.masdiq.util.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*

fun Route.userRoute(
    thisApp: Application,
    userDataInterface: UserDataInterface
) {
    authenticate("auth-session") {
        get(EndPoint.URL_USER_GET_INFO.path) {
            val userSession = call.principal<UserSession>()
            if (userSession == null) {
                thisApp.log.info(tokenEmpty)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    call.respond(
                        DefaultResponse(
                            status = "${HttpStatusCode.OK}",
                            message = dataAuthorized,
                            duration = "${call.processingTimeMillis().times(0.001)} seconds",
                            data = userDataInterface.getUserInfo(reqUserId = userSession.id)
                        )
                    )
                } catch (e: Exception) {
                    thisApp.log.info(tokenFailed)
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        get(EndPoint.URL_USER_SIGN_OUT.path) {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                thisApp.log.info(tokenEmpty)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    call.sessions.clear<UserSession>()
                    call.respond(
                        DefaultResponse(
                            status = "${HttpStatusCode.OK}",
                            message = userSignOut,
                            duration = "${call.processingTimeMillis().times(0.001)} seconds",
                            data = null
                        )
                    )
                } catch (e: Exception) {
                    thisApp.log.info(tokenFailed)
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        delete(EndPoint.URL_USER_DELETE.path) {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                thisApp.log.info(tokenEmpty)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    call.sessions.clear<UserSession>()
                    deleteUserFromDatabase(
                        app = thisApp,
                        userId = userSession.id,
                        userDataInterface = userDataInterface
                    )
                } catch (e: Exception) {
                    thisApp.log.info(tokenFailed)
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.deleteUserFromDatabase(
    app: Application,
    userId: String,
    userDataInterface: UserDataInterface
) {
    val result = userDataInterface.deleteUser(reqUserId = userId)
    if (result) {
        call.respond(
            DefaultResponse(
                status = "${HttpStatusCode.OK}",
                message = userDeleted,
                duration = "${call.processingTimeMillis().times(0.001)} seconds",
                data = null
            )
        )
    } else {
        call.respond(
            DefaultResponse(
                status = "${HttpStatusCode.OK}",
                message = userUnDeleted,
                duration = "${call.processingTimeMillis().times(0.001)} seconds",
                data = null
            )
        )
    }
}