package com.masdiq.database.pelayananDokter.trimester2

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class SkriningDiabetes(
    val gulaDarahPuasa: Int? = 0,
    val gulaDarahPostPrandial: Int? = 0,
    val rencanaTindakLanjut: String? = "Kosong",
    @BsonId
    val id: String = ObjectId().toString()
)
