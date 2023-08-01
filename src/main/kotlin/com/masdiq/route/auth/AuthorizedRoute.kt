package com.masdiq.route.auth

import com.masdiq.util.EndPoint
import com.masdiq.util.DefaultResponse
import com.masdiq.util.dataAuthorized
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authorizedRoute() {
    authenticate("auth-session") {
        get(EndPoint.URL_AUTHORIZED.path) {
            call.respond(
                DefaultResponse(
                    status = "${HttpStatusCode.OK}",
                    message = dataAuthorized,
                    duration = "${call.processingTimeMillis().times(0.001)} seconds",
                    data = null
                )
            )
        }
    }
}