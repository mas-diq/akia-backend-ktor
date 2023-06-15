package com.masdiq.model.pelayananDokter

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PelayananDokter(
    val namaDokter: String? = "d0001",
    val idDokter: String? = "id0001",
    val namaFaskes: String? = "f0001",
    val idFaskes: String? = "if0001",
)
