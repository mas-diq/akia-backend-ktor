package com.masdiq.model.pelayananDokter.evaluasi

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class RiwayatKehamilan(
    val nomor: Int? = 0,
    val tahun: Int? = 0,
    val beratLahir: Int? = 0,
    val persalinan: String? = "Normal",
    val penolongPersalinan: String? = "Dokter",
    val komplikasi: Boolean? = false,
    @BsonId
    var id: String = ObjectId().toString()
)
