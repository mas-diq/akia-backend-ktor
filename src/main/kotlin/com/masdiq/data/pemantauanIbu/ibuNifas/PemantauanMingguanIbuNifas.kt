package com.masdiq.data.pemantauanIbu.ibuNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PemantauanMingguanIbuNifas(
    val pemeriksaanNifas: Boolean? = false,
    val konsumsiVitaminA: Boolean? = false,
    val konsumsiTabletTambahDarah: Boolean? = false,
    val pemenuhanGiziSesuaiKebutuhan: Boolean? = false,
    @BsonId
    val id: String = ObjectId().toString()
)
