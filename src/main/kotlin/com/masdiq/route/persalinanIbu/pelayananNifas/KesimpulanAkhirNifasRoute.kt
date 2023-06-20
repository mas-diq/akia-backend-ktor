package com.masdiq.route.persalinanIbu.pelayananNifas

import com.masdiq.model.EndPoint
import com.masdiq.model.persalinanIbu.pelayananNifas.KesimpulanAkhirNifas
import com.masdiq.repository.persalinanIbu.pelayananNifas.KesimpulanAkhirNifasRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.kesimpulanAkhirNifasRoute() {
    val kesimpulanAkhirNifasRepository: KesimpulanAkhirNifasRepository by inject()

    get("${EndPoint.URL_KESIMPULAN_AKHIR_NIFAS.path}/get-all") {
        val dataList = kesimpulanAkhirNifasRepository.getAllKesimpulanAkhirNifas()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("${EndPoint.URL_KESIMPULAN_AKHIR_NIFAS.path}/get") { it ->
        val reqId = call.receive<KesimpulanAkhirNifas>().id
        val obj = kesimpulanAkhirNifasRepository.getKesimpulanAkhirNifas(reqId)

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

    post("${EndPoint.URL_KESIMPULAN_AKHIR_NIFAS.path}/create-update") {
        val request = try {
            call.receive<KesimpulanAkhirNifas>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (kesimpulanAkhirNifasRepository.createOrUpdateKesimpulanAkhirNifas(request)) {
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

    delete("${EndPoint.URL_KESIMPULAN_AKHIR_NIFAS.path}/delete") post@{
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

        if (kesimpulanAkhirNifasRepository.deleteKesimpulanAkhirNifas(request.id)) {
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