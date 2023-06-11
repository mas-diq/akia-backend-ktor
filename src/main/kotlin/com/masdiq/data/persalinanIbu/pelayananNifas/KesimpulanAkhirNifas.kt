package com.masdiq.data.persalinanIbu.pelayananNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class KesimpulanAkhirNifas(
    val keadaanIbu: Boolean? = true,
    val keadaanBayi: Boolean? = true,
    val komplikasiNifas: Boolean? = false,
    val kesimpulan: String? = "Kosong",
    @BsonId
    val id: String = ObjectId().toString()
)