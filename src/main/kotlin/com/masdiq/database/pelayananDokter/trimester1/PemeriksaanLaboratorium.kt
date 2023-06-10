package com.masdiq.database.pelayananDokter.trimester1

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

data class PemeriksaanLaboratorium(
    val tanggal: Date? = null,
    val hemoglobin: Int? = 0,
    val golonganDarah: Int? = 0,
    val gulaDarahSewaktu: Int? = 0,
    val ppia: Boolean? = true,
    @BsonId
    val id: String = ObjectId().toString()
)
