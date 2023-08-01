package com.masdiq.route.auth

import com.masdiq.util.EndPoint
import com.masdiq.util.DefaultResponse
import com.masdiq.util.dataUnauthorized
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.unauthorizedRoute() {
    get(EndPoint.URL_UNAUTHORIZED.path) {
        call.respond(
            DefaultResponse(
                status = "${HttpStatusCode.Unauthorized}",
                message = dataUnauthorized,
                duration = "${call.processingTimeMillis().times(0.001)} seconds",
                data = null
            )
        )
    }
}
