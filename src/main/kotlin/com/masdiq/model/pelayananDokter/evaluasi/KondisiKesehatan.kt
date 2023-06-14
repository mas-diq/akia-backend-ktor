package com.masdiq.model.pelayananDokter.evaluasi

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.util.*

data class KondisiKesehatan(
    val tanggal: Date? = null,
    val tinggiBadan: Int? = 0,
    val beratBadan: Int? = 0,
    val lingkarLengan: Int? = 0,
    val imt: Double? = 0.0,
    @BsonId
    var id: String = ObjectId().toString()
)
