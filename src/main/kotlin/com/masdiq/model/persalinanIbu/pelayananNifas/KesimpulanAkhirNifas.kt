package com.masdiq.model.persalinanIbu.pelayananNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class KesimpulanAkhirNifas(
    val keadaanIbu: Boolean? = true,
    val keadaanBayi: Boolean? = true,
    val komplikasiNifas: Boolean? = false,
    val kesimpulan: String? = "Kosong",
    @BsonId
    var id: String = ObjectId().toString()
)