package com.masdiq.route.pelayananDokter.trimester1

import com.masdiq.util.EndPoint
import com.masdiq.model.auth.UserSession
import com.masdiq.model.pelayananDokter.trimester1.PemeriksaanLaboratorium1
import com.masdiq.repository.pelayananDokter.trimester1.PemeriksaanLaboratorium1Repository
import com.masdiq.util.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemeriksaanLaboratorium1Route(app: Application) {
    val pemeriksaanLaboratorium1Repository: PemeriksaanLaboratorium1Repository by inject()

    authenticate("auth-session") {
        get("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_1.path}/get-user") {
            val userSession = call.principal<UserSession>()

            val userId = call.receive<PemeriksaanLaboratorium1>().userId.toString()
            val dataSearch = pemeriksaanLaboratorium1Repository.searchPemeriksaanLaboratorium1(reqId = userId)

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
        get("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_1.path}/get-all") {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUnauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    val dataList = pemeriksaanLaboratorium1Repository.getAllPemeriksaanLaboratorium1()
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
        get("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_1.path}/get") { it ->
            val userSession = call.principal<UserSession>()

            val reqId = call.receive<PemeriksaanLaboratorium1>().id
            val obj = pemeriksaanLaboratorium1Repository.getPemeriksaanLaboratorium1(reqId)

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
        post("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_1.path}/create-update") {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUnauthorized)
                call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path)
            } else {
                try {
                    val request = try {
                        call.receive<PemeriksaanLaboratorium1>()
                    } catch (e: ContentTransformationException) {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.BadRequest}",
                                dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                        return@post
                    }

                    if (pemeriksaanLaboratorium1Repository.createOrUpdatePemeriksaanLaboratorium1(request)) {
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
        delete("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_1.path}/delete") post@{
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

                    if (pemeriksaanLaboratorium1Repository.deletePemeriksaanLaboratorium1(request.id)) {
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