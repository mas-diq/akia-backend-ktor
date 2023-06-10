package com.masdiq.database.pelayananDokter

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class pemeriksaanFisik(
    val keadaanUmum: Boolean? = true,
    val konjungtiva: Boolean? = true,
    val sklera: Boolean? = true,
    val kulit: Boolean? = true,
    val leher: Boolean? = true,
    val gigi: Boolean? = true,
    val mulut: Boolean? = true,
    val tht: Boolean? = true,
    val dada: Boolean? = true,
    val paru: Boolean? = true,
    val perut: Boolean? = true,
    val tungkai: Boolean? = true,
    @BsonId
    val id: String = ObjectId().toString()
)