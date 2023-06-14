package com.masdiq.model.pelayananDokter.evaluasi

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class StatusImunisasi(
    // toksoid tetanus
    val tt1: Boolean? = false,
    val tt2: Boolean? = false,
    val tt3: Boolean? = false,
    val tt4: Boolean? = false,
    val tt5: Boolean? = false,
    @BsonId
    val id: String = ObjectId().toString()
)
