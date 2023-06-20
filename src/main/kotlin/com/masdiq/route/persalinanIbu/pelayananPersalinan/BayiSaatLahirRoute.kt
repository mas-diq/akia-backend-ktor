package com.masdiq.route.persalinanIbu.pelayananPersalinan

import com.masdiq.model.EndPoint
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.model.tabletTambahDarah.TabletTambahDarah
import com.masdiq.repository.persalinanIbu.pelayananPersalinan.BayiSaatLahirRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.bayiSaatLahirRoute() {
    val bayiSaatLahirRepository: BayiSaatLahirRepository by inject()

    get("${EndPoint.URL_TABLET_TAMBAH_DARAH.path}/get-user") {
        val userId = call.receive<TabletTambahDarah>().userId.toString()
        val dataSearch = bayiSaatLahirRepository.searchBayiSaatLahir(reqId = userId)
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataSearch
            )
        )
    }

    get("${EndPoint.URL_BAYI_SAAT_LAHIR.path}/get-all") {
        val dataList = bayiSaatLahirRepository.getAllBayiSaatLahir()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("${EndPoint.URL_BAYI_SAAT_LAHIR.path}/get") { it ->
        val reqId = call.receive<BayiSaatLahir>().id
        val obj = bayiSaatLahirRepository.getBayiSaatLahir(reqId)

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

    post("${EndPoint.URL_BAYI_SAAT_LAHIR.path}/create-update") {
        val request = try {
            call.receive<BayiSaatLahir>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (bayiSaatLahirRepository.createOrUpdateBayiSaatLahir(request)) {
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

    delete("${EndPoint.URL_BAYI_SAAT_LAHIR.path}/delete") post@{
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

        if (bayiSaatLahirRepository.deleteBayiSaatLahir(request.id)) {
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