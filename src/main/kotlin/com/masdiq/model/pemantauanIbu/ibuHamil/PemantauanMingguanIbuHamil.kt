package com.masdiq.model.pemantauanIbu.ibuHamil

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PemantauanMingguanIbuHamil(
    val trimester1: Int? = 0,
    val trimester2: Int? = 0,
    val trimester3: Int? = 0,
    @BsonId
    var id: String = ObjectId().toString()
)
