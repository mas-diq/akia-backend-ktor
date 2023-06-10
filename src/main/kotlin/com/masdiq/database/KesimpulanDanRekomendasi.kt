package com.masdiq.database

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class KesimpulanDanRekomendasi(
    val kesimpulan: String? = "Kosong",
    val rekomendasi: String? = "Kosong",
    val rujukan: Boolean? = false,
    @BsonId
    val id: String = ObjectId().toString()
)
