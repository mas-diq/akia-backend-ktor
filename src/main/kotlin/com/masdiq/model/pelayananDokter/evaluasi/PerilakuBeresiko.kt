package com.masdiq.model.pelayananDokter.evaluasi

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PerilakuBeresiko(
    val merokok: Boolean? = false,
    val polaMakan: Boolean? = false,
    val aktifitasFisik: Boolean? = false,
    val alkohol: Boolean? = false,
    val obatTeratogenik: Boolean? = false,
    val kosmetikBerbahaya: Boolean? = false,
    @BsonId
    var id: String = ObjectId().toString()
)