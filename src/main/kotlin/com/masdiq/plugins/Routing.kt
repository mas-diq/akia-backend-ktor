package com.masdiq.plugins

import com.masdiq.route.tambahDarahRoute
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        tambahDarahRoute()
        // Static plugin. Try to access `/static/index.html`
//        static("/static") {
//            resources("static")
//        }
    }
}
