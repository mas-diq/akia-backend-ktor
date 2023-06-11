package com.masdiq.data.pelayananDokter.trimester3

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class RencanaPersalinanDanKb(
    val normal: Boolean? = false,
    val pervaginam: Boolean? = false,
    val sectioCaesaria: Boolean? = false,
    val mal: Boolean? = false,
    val pil: Boolean? = false,
    val akdr: Boolean? = false,
    val implan: Boolean? = false,
    val steril: Boolean? = false,
    val belumMemilih: Boolean? = false,
    val konseling: Boolean? = false,
    @BsonId
    var id: String = ObjectId().toString()
)
