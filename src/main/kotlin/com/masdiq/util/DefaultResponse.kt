package com.masdiq.util

data class DefaultResponse<T>(
    val status: String? = "Kosong",
    val message: String? = "Kosong",
    val duration: String? = "Kosong",
    val data: T
)
