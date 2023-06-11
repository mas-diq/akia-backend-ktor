package com.masdiq.data.pelayananDokter.trimester3

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class UsgTrimester3(
    val janin: Boolean? = true,
    val jumlahJanin: Boolean? = true,
    val letakJanin: Boolean? = true,
    val beratJanin: Int? = 0,
    val plasenta: Boolean? = true,
    val usiaKehamilan: Int? = 0,
    @BsonId
    val id: String = ObjectId().toString()
)
