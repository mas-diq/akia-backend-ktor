package com.masdiq.route.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.RencanaPersalinanDanKb
import com.masdiq.repository.pelayananDokter.trimester3.RencanaPersalinanDanKbRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.rencanaPersalinanDanKbRoute() {
    val rencanaPersalinanDanKbRepository: RencanaPersalinanDanKbRepository by inject()

    get("$URL_RENCANA_PERSALINAN_DAN_KB/get-all") {
        val tabletList = rencanaPersalinanDanKbRepository.getAllRencanaPersalinanDanKb()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", tabletList
            )
        )
    }

    get("$URL_RENCANA_PERSALINAN_DAN_KB/get") { it ->
        val reqId = call.receive<RencanaPersalinanDanKb>().id
        val obj = rencanaPersalinanDanKbRepository.getRencanaPersalinanDanKb(reqId)

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

    post("$URL_RENCANA_PERSALINAN_DAN_KB/create-update") {
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
    }

    delete("$URL_RENCANA_PERSALINAN_DAN_KB/delete") post@{
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
    }
}