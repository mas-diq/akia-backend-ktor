package com.masdiq.model

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class KesimpulanDanRekomendasi(
    val kesimpulan: String? = "Kosong",
    val rujukan: Boolean? = false,
)
