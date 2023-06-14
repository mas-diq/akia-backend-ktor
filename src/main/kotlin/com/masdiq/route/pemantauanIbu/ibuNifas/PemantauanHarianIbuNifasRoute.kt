package com.masdiq.route.pemantauanIbu.ibuNifas

import com.masdiq.model.pemantauanIbu.ibuNifas.PemantauanHarianIbuNifas
import com.masdiq.repository.pemantauanIbu.ibuNifas.PemantauanHarianIbuNifasRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemantauanHarianIbuNifasRoute() {
    val pemantauanHarianIbuNifasRepository: PemantauanHarianIbuNifasRepository by inject()

    get("$URL_PEMANTAUAN_HARIAN_IBU_NIFAS/get") { it ->
        val reqId = call.receive<PemantauanHarianIbuNifas>().id
        val obj = pemantauanHarianIbuNifasRepository.getPemantauanHarianIbuNifas(reqId)

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

    post("$URL_PEMANTAUAN_HARIAN_IBU_NIFAS/create-update") {
        val request = try {
            call.receive<PemantauanHarianIbuNifas>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (pemantauanHarianIbuNifasRepository.createOrUpdatePemantauanHarianIbuNifas(request)) {
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

    post("$URL_PEMANTAUAN_HARIAN_IBU_NIFAS/delete") {
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

        if (pemantauanHarianIbuNifasRepository.deletePemantauanHarianIbuNifas(request.id)) {
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