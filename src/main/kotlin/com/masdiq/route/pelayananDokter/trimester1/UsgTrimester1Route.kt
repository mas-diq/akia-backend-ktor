package com.masdiq.route.pelayananDokter.trimester1

import com.masdiq.model.EndPoint
import com.masdiq.model.pelayananDokter.trimester1.UsgTrimester1
import com.masdiq.repository.pelayananDokter.trimester1.UsgTrimester1Repository
import com.masdiq.template.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.usgTrimester1Route() {
    val usgTrimester1Repository: UsgTrimester1Repository by inject()

    get("${EndPoint.URL_USG_TRIMESTER_1.path}/get-user") {
        val userId = call.receive<UsgTrimester1>().userId.toString()
        val dataSearch = usgTrimester1Repository.searchUsgTrimester1(reqId = userId)
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataSearch
            )
        )
    }

    get("${EndPoint.URL_USG_TRIMESTER_1.path}/get-all") {
        val dataList = usgTrimester1Repository.getAllUsgTrimester1()
        call.respond(
            DefaultResponse(
                "${HttpStatusCode.OK}",
                dataSuccessRetrieved, "${call.processingTimeMillis().times(0.001)} seconds", dataList
            )
        )
    }

    get("${EndPoint.URL_USG_TRIMESTER_1.path}/get") { it ->
        val reqId = call.receive<UsgTrimester1>().id
        val obj = usgTrimester1Repository.getUsgTrimester1(reqId)

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

    post("${EndPoint.URL_USG_TRIMESTER_1.path}/create-update") {
        val request = try {
            call.receive<UsgTrimester1>()
        } catch (e: ContentTransformationException) {
            call.respond(
                DefaultResponse(
                    "${HttpStatusCode.BadRequest}",
                    dataJsonError, "${call.processingTimeMillis().times(0.001)} seconds", it
                )
            )
            return@post
        }

        if (usgTrimester1Repository.createOrUpdateUsgTrimester1(request)) {
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

    delete("${EndPoint.URL_USG_TRIMESTER_1.path}/delete") post@{
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

        if (usgTrimester1Repository.deleteUsgTrimester1(request.id)) {
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