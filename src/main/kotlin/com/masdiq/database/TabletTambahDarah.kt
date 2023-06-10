package com.masdiq.database

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class TabletTambahDarah(
    val bulan1: Boolean? = false,
    val bulan2: Boolean? = false,
    val bulan3: Boolean? = false,
    val bulan4: Boolean? = false,
    val bulan5: Boolean? = false,
    val bulan6: Boolean? = false,
    val bulan7: Boolean? = false,
    val bulan8: Boolean? = false,
    val bulan9: Boolean? = false,
    @BsonId
    var id: String = ObjectId().toString()
)
