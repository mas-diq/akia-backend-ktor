package com.masdiq.route.persalinanIbu.pelayananPersalinan

import com.masdiq.model.persalinanIbu.pelayananPersalinan.IbuBersalinDanIbuNifas
import com.masdiq.repository.persalinanIbu.pelayananPersalinan.IbuBersalinDanIbuNifasRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.ibuBersalinDanIbuNifasRoute() {
    val ibuBersalinDanIbuNifasRepository: IbuBersalinDanIbuNifasRepository by inject()

    get("$URL_IBU_BERSALIN_DAN_IBU_NIFAS/get-all") {
        val dataList = ibuBersalinDanIbuNifasRepository.getAllIbuBersalinDanIbuNifas()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("$URL_IBU_BERSALIN_DAN_IBU_NIFAS/get") { it ->
        val reqId = call.receive<IbuBersalinDanIbuNifas>().id
        val obj = ibuBersalinDanIbuNifasRepository.getIbuBersalinDanIbuNifas(reqId)

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

    post("$URL_IBU_BERSALIN_DAN_IBU_NIFAS/create-update") {
        val request = try {
            call.receive<IbuBersalinDanIbuNifas>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (ibuBersalinDanIbuNifasRepository.createOrUpdateIbuBersalinDanIbuNifas(request)) {
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

    delete("$URL_IBU_BERSALIN_DAN_IBU_NIFAS/delete") post@{
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

        if (ibuBersalinDanIbuNifasRepository.deleteIbuBersalinDanIbuNifas(request.id)) {
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
