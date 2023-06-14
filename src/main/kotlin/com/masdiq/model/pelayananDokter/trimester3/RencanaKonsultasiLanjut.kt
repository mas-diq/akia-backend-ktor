package com.masdiq.model.pelayananDokter.trimester3

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class RencanaKonsultasiLanjut(
    val gizi: Boolean? = false,
    val kebidanan: Boolean? = false,
    val anak: Boolean? = false,
    val penyakitDalam: Boolean? = false,
    val neurologi: Boolean? = false,
    val tht: Boolean? = false,
    val psikiatri: Boolean? = false,
    @BsonId
    var id: String = ObjectId().toString()
)
