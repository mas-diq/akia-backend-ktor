package com.masdiq.data.pelayananDokter

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PelayananDokter(
    val namaDokter: String? = "Kosong",
    val namaFaskes: String? = "Kosong",
    @BsonId
    val id: String = ObjectId().toString()
)
