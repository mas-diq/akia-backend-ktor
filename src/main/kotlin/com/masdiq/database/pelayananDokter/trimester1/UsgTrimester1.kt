package com.masdiq.database.pelayananDokter.trimester1

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class UsgTrimester1(
    val keadaanUmum: Boolean? = true,
    val gestationalSac: Int? = 0,
    val CrownrumpLength: Int? = 0,
    val DenyutJantungJanin: Int? = 0,
    val usiaKehamilan: Int? = 0,
    val letakKantongKehamilan: String? = "Intauterin",
    val taksiranPersalinan: Int = 0,
    @BsonId
    val id: String = ObjectId().toString()
)
