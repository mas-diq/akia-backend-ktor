package com.masdiq.route.pemantauanIbu.ibuHamil

import com.masdiq.model.pemantauanIbu.ibuHamil.PemantauanHarianIbuHamil
import com.masdiq.repository.pemantauanIbu.ibuHamil.PemantauanHarianIbuHamilRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemantauanHarianIbuHamilRoute() {
    val pemantauanHarianIbuHamilRepository: PemantauanHarianIbuHamilRepository by inject()

    get("$URL_PEMANTAUAN_HARIAN_IBU_HAMIL/get-all") {
        val tabletList = pemantauanHarianIbuHamilRepository.getAllPemantauanHarianIbuHamil()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", tabletList
            )
        )
    }

    get("$URL_PEMANTAUAN_HARIAN_IBU_HAMIL/get") { it ->
        val reqId = call.receive<PemantauanHarianIbuHamil>().id
        val obj = pemantauanHarianIbuHamilRepository.getPemantauanHarianIbuHamil(reqId)

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

    post("$URL_PEMANTAUAN_HARIAN_IBU_HAMIL/create-update") {
        val request = try {
            call.receive<PemantauanHarianIbuHamil>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (pemantauanHarianIbuHamilRepository.createOrUpdatePemantauanHarianIbuHamil(request)) {
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

    delete("$URL_PEMANTAUAN_HARIAN_IBU_HAMIL/delete") post@{
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

        if (pemantauanHarianIbuHamilRepository.deletePemantauanHarianIbuHamil(request.id)) {
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