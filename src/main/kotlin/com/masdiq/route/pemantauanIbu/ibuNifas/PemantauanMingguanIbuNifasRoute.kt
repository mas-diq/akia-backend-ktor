package com.masdiq.route.pemantauanIbu.ibuNifas

import com.masdiq.model.pemantauanIbu.ibuNifas.PemantauanMingguanIbuNifas
import com.masdiq.repository.pemantauanIbu.ibuNifas.PemantauanMingguanIbuNifasRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemantauanMingguanIbuNifasRoute() {
    val pemantauanMingguanIbuNifasRepository: PemantauanMingguanIbuNifasRepository by inject()

    get("$URL_PEMANTAUAN_MINGGUAN_IBU_NIFAS/get-all") {
        val tabletList = pemantauanMingguanIbuNifasRepository.getAllPemantauanMingguanIbuNifas()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", tabletList
            )
        )
    }

    get("$URL_PEMANTAUAN_MINGGUAN_IBU_NIFAS/get") { it ->
        val reqId = call.receive<PemantauanMingguanIbuNifas>().id
        val obj = pemantauanMingguanIbuNifasRepository.getPemantauanMingguanIbuNifas(reqId)

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

    post("$URL_PEMANTAUAN_MINGGUAN_IBU_NIFAS/create-update") {
        val request = try {
            call.receive<PemantauanMingguanIbuNifas>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (pemantauanMingguanIbuNifasRepository.createOrUpdatePemantauanMingguanIbuNifas(request)) {
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

    delete("$URL_PEMANTAUAN_MINGGUAN_IBU_NIFAS/delete") post@{
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

        if (pemantauanMingguanIbuNifasRepository.deletePemantauanMingguanIbuNifas(request.id)) {
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