package com.masdiq.route.pelayananDokter.evaluasi

import com.masdiq.model.EndPoint
import com.masdiq.model.auth.UserSession
import com.masdiq.model.pelayananDokter.evaluasi.PemeriksaanKhusus
import com.masdiq.repository.pelayananDokter.evaluasi.PemeriksaanKhususRepository
import com.masdiq.util.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemeriksaanKhususRoute(app: Application) {
    val pemeriksaanKhususRepository: PemeriksaanKhususRepository by inject()

    authenticate("auth-session") {
        get("${EndPoint.URL_PEMERIKSAAN_KHUSUS.path}/get-user") {
            val userSession = call.principal<UserSession>()

            val userId = call.receive<PemeriksaanKhusus>().userId.toString()
            val dataSearch = pemeriksaanKhususRepository.searchPemeriksaanKhusus(reqId = userId)

            if (userSession == null) {
                app.log.info(dataUauthorized)
                call.respondRedirect(EndPoint.Unauthorized.path)
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
                    call.respondRedirect(EndPoint.Unauthorized.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        get("${EndPoint.URL_PEMERIKSAAN_KHUSUS.path}/get-all") {
            val userSession = call.principal<UserSession>()

            val dataList = pemeriksaanKhususRepository.getAllPemeriksaanKhusus()

            if (userSession == null) {
                app.log.info(dataUauthorized)
                call.respondRedirect(EndPoint.Unauthorized.path)
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
                    call.respondRedirect(EndPoint.Unauthorized.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        get("${EndPoint.URL_PEMERIKSAAN_KHUSUS.path}/get") { it ->
            val userSession = call.principal<UserSession>()

            val reqId = call.receive<PemeriksaanKhusus>().id
            val obj = pemeriksaanKhususRepository.getPemeriksaanKhusus(reqId)

            if (userSession == null) {
                app.log.info(dataUauthorized)
                call.respondRedirect(EndPoint.Unauthorized.path)
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
                    call.respondRedirect(EndPoint.Unauthorized.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        post("${EndPoint.URL_PEMERIKSAAN_KHUSUS.path}/create-update") {
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUauthorized)
                call.respondRedirect(EndPoint.Unauthorized.path)
            } else {
                try {
                    val request = try {
                        call.receive<PemeriksaanKhusus>()
                    } catch (e: ContentTransformationException) {
                        call.respond(
                            DefaultResponse(
                                "${HttpStatusCode.BadRequest}",
                                dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                            )
                        )
                        return@post
                    }

                    if (pemeriksaanKhususRepository.createOrUpdatePemeriksaanKhusus(request)) {
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
                    call.respondRedirect(EndPoint.Unauthorized.path)
                }
            }
        }
    }

    authenticate("auth-session") {
        delete("${EndPoint.URL_PEMERIKSAAN_KHUSUS.path}/delete") post@{
            val userSession = call.principal<UserSession>()

            if (userSession == null) {
                app.log.info(dataUauthorized)
                call.respondRedirect(EndPoint.Unauthorized.path)
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

                    if (pemeriksaanKhususRepository.deletePemeriksaanKhusus(request.id)) {
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
                    call.respondRedirect(EndPoint.Unauthorized.path)
                }
            }
        }
    }
}
