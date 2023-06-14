package com.masdiq.model.persalinanIbu.pelayananPersalinan

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

data class IbuBersalinDanIbuNifas(
    val tanggalPersalinan: Date? = null,
    val waktuPersalinan: Date? = null,
    val umurKehamilan: Int? = 0,
    val penolongPersalinan: String? = "Kosong",
    val caraPersalinan: String? = "Kosong",
    val keadaanIbu: String? = "Kosong",
    val kBPascaPersalinan: Boolean? = true,
    val keteranganTambahan: String? = "Kosong",
    @BsonId
    var id: String = ObjectId().toString()
)