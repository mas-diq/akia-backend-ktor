package com.masdiq.model.pelayananDokter

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PelayananDokter(
    val namaDokter: String? = "Kosong",
    val idDokter: String? = "0000",
    val namaFaskes: String? = "Kosong",
    val idFaskes: String? = "0000",
    @BsonId
    val id: String = ObjectId().toString()
)
