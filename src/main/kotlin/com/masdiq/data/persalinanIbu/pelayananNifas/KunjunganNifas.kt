package com.masdiq.data.persalinanIbu.pelayananNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

data class KunjunganNifas(
    val tanggal: Date? = null,
    val namaDokter: String? = "Kosong",
    val namaFaskes: String? = "Kosong",
    val kunjunganNifasKe: Int? = 0,
    val klarifikasi: String? = "Kosong",
    val tindakan: String? = "Kosong",
    @BsonId
    val id: String = ObjectId().toString()
)
