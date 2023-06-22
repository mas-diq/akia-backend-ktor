package com.masdiq.route.pemantauanIbu.ibuHamil

import com.masdiq.model.EndPoint
import com.masdiq.model.auth.UserSession
import com.masdiq.model.pemantauanIbu.ibuHamil.PemantauanMingguanIbuHamil
import com.masdiq.repository.pemantauanIbu.ibuHamil.PemantauanMingguanIbuHamilRepository
import com.masdiq.util.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemantauanMingguanIbuHamilRoute(app: Application) {
    val pemantauanMingguanIbuHamilRepository: PemantauanMingguanIbuHamilRepository by inject()

    authenticate("auth-session") {
        get("${EndPoint.URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL.path}/get-user") {
            val userSession = call.principal<UserSession>()

            val userId = call.receive<PemantauanMingguanIbuHamil>().userId.toString()
            val dataSearch = pemantauanMingguanIbuHamilRepository.searchPemantauanMingguanIbuHamil(reqId = userId)

            if (userSession == null) {
                app.log.info(dataUauthorized)
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
                    app.log.info("$dataUauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        get("${EndPoint.URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL.path}/get-all") {
            val userSession = call.principal<UserSession>()

            val dataList = pemantauanMingguanIbuHamilRepository.getAllPemantauanMingguanIbuHamil()

            if (userSession == null) {
                app.log.info(dataUauthorized)
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
                    app.log.info("$dataUauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        get("${EndPoint.URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL.path}/get") { it ->
            val userSession = call.principal<UserSession>()

            val reqId = call.receive<PemantauanMingguanIbuHamil>().id
            val obj = pemantauanMingguanIbuHamilRepository.getPemantauanMingguanIbuHamil(reqId)

            if (userSession == null) {
                app.log.info(dataUauthorized)
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
                    app.log.info("$dataUauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        post("${EndPoint.URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL.path}/create-update") {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    val request = try {
                        call.receive<PemantauanMingguanIbuHamil>()
                    } catch (e: ContentTransformationException) {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.BadRequest}",
                                dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                        return@post
                    }

                    if (pemantauanMingguanIbuHamilRepository.createOrUpdatePemantauanMingguanIbuHamil(request)) {
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
                    app.log.info("$dataUauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        delete("${EndPoint.URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL.path}/delete") post@{
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUauthorized)
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

                    if (pemantauanMingguanIbuHamilRepository.deletePemantauanMingguanIbuHamil(request.id)) {
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
                    app.log.info("$dataUauthorized, because $e")
                    call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
                }
            }
        }
    }
}