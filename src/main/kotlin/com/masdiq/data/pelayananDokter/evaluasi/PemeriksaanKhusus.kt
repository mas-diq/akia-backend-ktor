package com.masdiq.data.pelayananDokter.evaluasi

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PemeriksaanKhusus(
    val inspeksi: Boolean? = false,
    val inspekulo: Boolean? = false,
    val vulva: Boolean? = false,
    val uretra: Boolean? = false,
    val vagina: Boolean? = false,
    val fluksus: Boolean? = false,
    val fluour: Boolean? = false,
    val posio: Boolean? = false,
    @BsonId
    val id: String = ObjectId().toString()
)
