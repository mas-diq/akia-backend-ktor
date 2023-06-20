package com.masdiq.route.pelayananDokter.trimester3

import com.masdiq.model.EndPoint
import com.masdiq.model.pelayananDokter.trimester3.PemeriksaanLaboratorium2
import com.masdiq.model.tabletTambahDarah.TabletTambahDarah
import com.masdiq.repository.pelayananDokter.trimester3.PemeriksaanLaboratorium2Repository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.pemeriksaanLaboratorium2Route() {
    val pemeriksaanLaboratorium2Repository: PemeriksaanLaboratorium2Repository by inject()

    get("${EndPoint.URL_TABLET_TAMBAH_DARAH.path}/get-user") {
        val userId = call.receive<TabletTambahDarah>().userId.toString()
        val dataSearch = pemeriksaanLaboratorium2Repository.searchPemeriksaanLaboratorium2(reqId = userId)
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataSearch
            )
        )
    }

    get("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/get-all") {
        val dataList = pemeriksaanLaboratorium2Repository.getAllPemeriksaanLaboratorium2()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/get") { it ->
        val reqId = call.receive<PemeriksaanLaboratorium2>().id
        val obj = pemeriksaanLaboratorium2Repository.getPemeriksaanLaboratorium2(reqId)

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

    post("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/create-update") {
        val request = try {
            call.receive<PemeriksaanLaboratorium2>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (pemeriksaanLaboratorium2Repository.createOrUpdatePemeriksaanLaboratorium2(request)) {
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

    delete("${EndPoint.URL_PEMERIKSAAN_LABORATORIUM_2.path}/delete") post@{
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

        if (pemeriksaanLaboratorium2Repository.deletePemeriksaanLaboratorium2(request.id)) {
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