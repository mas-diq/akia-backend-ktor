package com.masdiq.route.pelayananDokter.trimester3

import com.masdiq.model.EndPoint
import com.masdiq.model.pelayananDokter.trimester3.RencanaKonsultasiLanjut
import com.masdiq.repository.pelayananDokter.trimester3.RencanaKonsultasiLanjutRepository
import com.masdiq.util.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.rencanaKonsultasiLanjutRoute() {
    val rencanaKonsultasiLanjutRepository: RencanaKonsultasiLanjutRepository by inject()

    get("${EndPoint.URL_RENCANA_KONSULTASI_LANJUT.path}/get-all") {
        val dataList = rencanaKonsultasiLanjutRepository.getAllRencanaKonsultasiLanjut()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("${EndPoint.URL_RENCANA_KONSULTASI_LANJUT.path}/get") { it ->
        val reqId = call.receive<RencanaKonsultasiLanjut>().id
        val obj = rencanaKonsultasiLanjutRepository.getRencanaKonsultasiLanjut(reqId)

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

    post("${EndPoint.URL_RENCANA_KONSULTASI_LANJUT.path}/create-update") {
        val request = try {
            call.receive<RencanaKonsultasiLanjut>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (rencanaKonsultasiLanjutRepository.createOrUpdateRencanaKonsultasiLanjut(request)) {
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

    delete("${EndPoint.URL_RENCANA_KONSULTASI_LANJUT.path}/delete") post@{
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

        if (rencanaKonsultasiLanjutRepository.deleteRencanaKonsultasiLanjut(request.id)) {
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