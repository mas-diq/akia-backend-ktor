package com.masdiq.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class CatatanPelayanan(
    @BsonId
    val stamp: Boolean? = true,
    val paraf: Boolean? = false,
    val keluhan: String? = "Kosong",
    val pemeriksaan: String? = "Kosong",
    val tindakan: String? = "Kosong",
    val saran: String? = "Kosong",
    val tanggalKembali: String? = "Kosong",
    val kesimpulanDanRekomendasi: KesimpulanDanRekomendasi,
)
