package com.masdiq.route.pelayananDokter.trimester3

import com.masdiq.util.EndPoint
import com.masdiq.model.auth.UserSession
import com.masdiq.model.pelayananDokter.trimester3.RencanaPersalinanDanKb
import com.masdiq.repository.pelayananDokter.trimester3.RencanaPersalinanDanKbRepository
import com.masdiq.util.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.rencanaPersalinanDanKbRoute(app: Application) {
    val rencanaPersalinanDanKbRepository: RencanaPersalinanDanKbRepository by inject()

    authenticate("auth-session") {
        get("${EndPoint.URL_RENCANA_PERSALINAN_DAN_KB.path}/get-user") {
            val userSession = call.principal<UserSession>()

            val userId = call.receive<RencanaPersalinanDanKb>().userId.toString()
            val dataSearch = rencanaPersalinanDanKbRepository.searchRencanaPersalinanDanKb(reqId = userId)

            if (userSession == null) {
                app.log.info(dataUnauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    call.respond(
                        DefaultResponse(
                            "${HttpStatusCode.OK}",
                            dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataSearch
                        )
                    )
                } catch (e: Exception) {
                    app.log.info("$dataUnauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        get("${EndPoint.URL_RENCANA_PERSALINAN_DAN_KB.path}/get-all") {
            val userSession = call.principal<UserSession>()

            val dataList = rencanaPersalinanDanKbRepository.getAllRencanaPersalinanDanKb()

            if (userSession == null) {
                app.log.info(dataUnauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    call.respond(
                        DefaultResponse(
                            "${HttpStatusCode.OK}",
                            dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
                        )
                    )
                } catch (e: Exception) {
                    app.log.info("$dataUnauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        get("${EndPoint.URL_RENCANA_PERSALINAN_DAN_KB.path}/get") { it ->
            val userSession = call.principal<UserSession>()

            val reqId = call.receive<RencanaPersalinanDanKb>().id
            val obj = rencanaPersalinanDanKbRepository.getRencanaPersalinanDanKb(reqId)

            if (userSession == null) {
                app.log.info(dataUnauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    obj?.let {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.OK}",
                                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                    } ?: call.respond(
                        DefaultResponse(
                            "${HttpStatusCode.NotFound}",
                            dataNotFound, "${call.processingTimeMillis().times(0.001)} seconds", it
                        )
                    )
                } catch (e: Exception) {
                    app.log.info("$dataUnauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        post("${EndPoint.URL_RENCANA_PERSALINAN_DAN_KB.path}/create-update") {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUnauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    val request = try {
                        call.receive<RencanaPersalinanDanKb>()
                    } catch (e: ContentTransformationException) {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.BadRequest}",
                                dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                        return@post
                    }

                    if (rencanaPersalinanDanKbRepository.createOrUpdateRencanaPersalinanDanKb(request)) {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.OK}",
                                dataSuccessCreated, "${call.processingTimeMillis().times(0.001)} seconds", request
                            )
                        )
                    } else {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.Conflict}",
                                dataConflict, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                    }
                } catch (e: Exception) {
                    app.log.info("$dataUnauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        delete("${EndPoint.URL_RENCANA_PERSALINAN_DAN_KB.path}/delete") post@{
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUnauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    val request = try {
                        call.receive<DefaultRequest>()
                    } catch (e: ContentTransformationException) {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.BadRequest}",
                                dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                        return@post
                    }

                    if (rencanaPersalinanDanKbRepository.deleteRencanaPersalinanDanKb(request.id)) {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.OK}",
                                dataSuccessDeleted, "${call.processingTimeMillis().times(0.001)} seconds", request
                            )
                        )
                    } else {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.BadRequest}",
                                dataNotFound, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                    }
                } catch (e: Exception) {
                    app.log.info("$dataUnauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }
}