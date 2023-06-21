package com.masdiq.route.persalinanIbu.pelayananPersalinan

import com.masdiq.model.EndPoint
import com.masdiq.model.persalinanIbu.pelayananPersalinan.IbuBersalinDanIbuNifas
import com.masdiq.repository.persalinanIbu.pelayananPersalinan.IbuBersalinDanIbuNifasRepository
import com.masdiq.util.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.ibuBersalinDanIbuNifasRoute() {
    val ibuBersalinDanIbuNifasRepository: IbuBersalinDanIbuNifasRepository by inject()

    get("${EndPoint.URL_IBU_BERSALIN_DAN_IBU_NIFAS.path}/get-user") {
        val userId = call.receive<IbuBersalinDanIbuNifas>().userId.toString()
        val dataSearch = ibuBersalinDanIbuNifasRepository.searchIbuBersalinDanIbuNifas(reqId = userId)
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataSearch
            )
        )
    }
    get("${EndPoint.URL_IBU_BERSALIN_DAN_IBU_NIFAS.path}/get-all") {
        val dataList = ibuBersalinDanIbuNifasRepository.getAllIbuBersalinDanIbuNifas()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("${EndPoint.URL_IBU_BERSALIN_DAN_IBU_NIFAS.path}/get") { it ->
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

    post("${EndPoint.URL_IBU_BERSALIN_DAN_IBU_NIFAS.path}/create-update") {
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

    delete("${EndPoint.URL_IBU_BERSALIN_DAN_IBU_NIFAS.path}/delete") post@{
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
