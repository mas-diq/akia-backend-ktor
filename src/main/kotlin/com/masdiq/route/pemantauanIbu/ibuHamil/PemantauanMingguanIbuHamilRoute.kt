package com.masdiq.route.pemantauanIbu.ibuHamil

import com.masdiq.model.pemantauanIbu.ibuHamil.PemantauanMingguanIbuHamil
import com.masdiq.repository.pemantauanIbu.ibuHamil.PemantauanMingguanIbuHamilRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemantauanMingguanIbuHamilRoute() {
    val pemantauanMingguanIbuHamilRepository: PemantauanMingguanIbuHamilRepository by inject()

    get("$URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL/get") { it ->
        val reqId = call.receive<PemantauanMingguanIbuHamil>().id
        val obj = pemantauanMingguanIbuHamilRepository.getPemantauanMingguanIbuHamil(reqId)

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

    post("$URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL/create-update") {
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
    }

    post("$URL_PEMANTAUAN_MINGGUAN_IBU_HAMIL/delete") {
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
    }
}