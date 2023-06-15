package com.masdiq.template

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class DefaultResponse<T>(
    val status: String? = "Kosong",
    val message: String? = "Kosong",
    val duration: String? = "Kosong",
    val data: T
)
