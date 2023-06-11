package com.masdiq.data

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

data class CatatanPelayanan(
    val tanggal: Date? = null,
    val stamp: Boolean? = true,
    val paraf: Boolean? = false,
    val keluhan: String? = "Kosong",
    val pemeriksaan: String? = "Kosong",
    val tindakan: String? = "Kosong",
    val saran: String? = "Kosong",
    val tanggalKembali: Date? = null,
    @BsonId
    val id: String = ObjectId().toString()
)
