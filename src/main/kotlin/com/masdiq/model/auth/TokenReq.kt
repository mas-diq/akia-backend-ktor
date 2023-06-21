package com.masdiq.model.auth

data class TokenReq(
    val tokenId: String,
    val userType: String
)