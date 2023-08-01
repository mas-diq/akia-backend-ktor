package com.masdiq.plugins

import com.masdiq.util.EndPoint
import com.masdiq.model.auth.UserSession
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*

fun Application.configureAut() {
    install(Authentication) {
        session<UserSession>(
            name = "auth-session"
        ) {
            validate { session -> session }
            challenge { call.respondRedirect(EndPoint.URL_UNAUTHORIZED.path) }
        }

    }
}