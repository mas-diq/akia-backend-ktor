package com.masdiq.model.auth

import io.ktor.server.auth.*

data class UserSession(
    val id: String,
    val name: String
) : Principal
