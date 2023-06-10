package com.masdiq.model.pemantauanIbu

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PemantauanMingguan(
    val trimester1: Int? = 0,
    val trimester2: Int? = 0,
    val trimester3: Int? = 0,
    @BsonId
    val id: String = ObjectId().toString()
)
