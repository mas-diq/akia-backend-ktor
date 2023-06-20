package com.masdiq.route.pelayananDokter

import com.masdiq.model.EndPoint
import com.masdiq.model.pelayananDokter.PemeriksaanFisik
import com.masdiq.repository.pelayananDokter.PemeriksaanFisikRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.pemeriksaanFisikRoute() {
    val pemeriksaanFisikRepository: PemeriksaanFisikRepository by inject()

    get("${EndPoint.URL_PEMERIKSAAN_FISIK.path}/get-user") {
        val userId = call.receive<PemeriksaanFisik>().userId.toString()
        val dataSearch = pemeriksaanFisikRepository.searchPemeriksaanFisik(reqId = userId)
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataSearch
            )
        )
    }

    get("${EndPoint.URL_PEMERIKSAAN_FISIK.path}/get-all") {
        val dataList = pemeriksaanFisikRepository.getAllPemeriksaanFisik()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("${EndPoint.URL_PEMERIKSAAN_FISIK.path}/get") { it ->
        val reqId = call.receive<PemeriksaanFisik>().id
        val obj = pemeriksaanFisikRepository.getPemeriksaanFisik(reqId)

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
    }

    post("${EndPoint.URL_PEMERIKSAAN_FISIK.path}/create-update") {
        val request = try {
            call.receive<PemeriksaanFisik>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (pemeriksaanFisikRepository.createOrUpdatePemeriksaanFisik(request)) {
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
    }

    delete("${EndPoint.URL_PEMERIKSAAN_FISIK.path}/delete") post@{
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

        if (pemeriksaanFisikRepository.deletePemeriksaanFisik(request.id)) {
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
    }
}
    
