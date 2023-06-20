package com.masdiq.route.pelayananDokter.evaluasi

import com.masdiq.model.EndPoint
import com.masdiq.model.pelayananDokter.evaluasi.KondisiKesehatan
import com.masdiq.model.tabletTambahDarah.TabletTambahDarah
import com.masdiq.repository.pelayananDokter.evaluasi.KondisiKesehatanRepository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.kondisiKesehatanRoute() {
    val kondisiKesehatanRepository: KondisiKesehatanRepository by inject()

    get("${EndPoint.URL_TABLET_TAMBAH_DARAH.path}/get-user") {
        val userId = call.receive<TabletTambahDarah>().userId.toString()
        val dataSearch = kondisiKesehatanRepository.searchKondisiKesehatan(reqId = userId)
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataSearch
            )
        )
    }

    get("${EndPoint.URL_KONDISI_KESEHATAN.path}/get-all") {
        val dataList = kondisiKesehatanRepository.getAllKondisiKesehatan()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("${EndPoint.URL_KONDISI_KESEHATAN.path}/get") { it ->
        val reqId = call.receive<KondisiKesehatan>().id
        val obj = kondisiKesehatanRepository.getKondisiKesehatan(reqId)

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

    post("${EndPoint.URL_KONDISI_KESEHATAN.path}/create-update") {
        val request = try {
            call.receive<KondisiKesehatan>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (kondisiKesehatanRepository.createOrUpdateKondisiKesehatan(request)) {
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

    delete("${EndPoint.URL_KONDISI_KESEHATAN.path}/delete") post@{
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

        if (kondisiKesehatanRepository.deleteKondisiKesehatan(request.id)) {
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
