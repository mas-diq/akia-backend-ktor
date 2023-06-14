package com.masdiq.model.pelayananDokter.trimester3

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

data class PemeriksaanLaboratorium2(
    val tanggal: Date? = null,
    val hemoglobin: Int? = 0,
    val proteinUrin: Int? = 0,
    val urinReduksi: Int? = 0,
    val rencanaTindakLanjut: String? = "Kosong",
    @BsonId
    var id: String = ObjectId().toString()
)
