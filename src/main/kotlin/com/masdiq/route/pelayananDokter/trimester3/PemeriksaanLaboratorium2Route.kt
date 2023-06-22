package com.masdiq.route.pelayananDokter.trimester3

import com.masdiq.model.EndPoint
import com.masdiq.model.auth.UserSession
import com.masdiq.model.pelayananDokter.trimester3.PemeriksaanLaboratorium2
import com.masdiq.repository.pelayananDokter.trimester3.PemeriksaanLaboratorium2Repository
import com.masdiq.util.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemeriksaanLaboratorium2Route(app: Application) {
    val pemeriksaanLaboratorium2Repository: PemeriksaanLaboratorium2Repository by inject()

    authenticate("auth-session") {
        get("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/get-user") {
            val userSession = call.principal<UserSession>()

            val userId = call.receive<PemeriksaanLaboratorium2>().userId.toString()
            val dataSearch = pemeriksaanLaboratorium2Repository.searchPemeriksaanLaboratorium2(reqId = userId)

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
        get("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/get-all") {
            val userSession = call.principal<UserSession>()

            val dataList = pemeriksaanLaboratorium2Repository.getAllPemeriksaanLaboratorium2()

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
        get("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/get") { it ->
            val userSession = call.principal<UserSession>()

            val reqId = call.receive<PemeriksaanLaboratorium2>().id
            val obj = pemeriksaanLaboratorium2Repository.getPemeriksaanLaboratorium2(reqId)

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
        post("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/create-update") {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    val request = try {
                        call.receive<PemeriksaanLaboratorium2>()
                    } catch (e: ContentTransformationException) {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.BadRequest}",
                                dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                        return@post
                    }

                    if (pemeriksaanLaboratorium2Repository.createOrUpdatePemeriksaanLaboratorium2(request)) {
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
        delete("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/delete") post@{
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

                    if (pemeriksaanLaboratorium2Repository.deletePemeriksaanLaboratorium2(request.id)) {
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