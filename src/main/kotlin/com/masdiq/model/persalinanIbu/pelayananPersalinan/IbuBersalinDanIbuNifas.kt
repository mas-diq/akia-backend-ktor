package com.masdiq.model.persalinanIbu.pelayananPersalinan

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDate
import java.time.LocalDateTime

data class IbuBersalinDanIbuNifas(
    val tanggalPersalinan: String? = LocalDate.now().toString(),
    val waktuPersalinan: String? = LocalDateTime.now().toString(),
    val umurKehamilan: Int? = 0,
    val penolongPersalinan: String? = "Kosong",
    val caraPersalinan: String? = "Kosong",
    val keadaanIbu: String? = "Kosong",
    val kBPascaPersalinan: Boolean? = true,
    val keteranganTambahan: String? = "Kosong",
    @BsonId
    var id: String = ObjectId().toString()
)