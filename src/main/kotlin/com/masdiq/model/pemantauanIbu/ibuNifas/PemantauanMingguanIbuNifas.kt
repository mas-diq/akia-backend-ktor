package com.masdiq.model.pemantauanIbu.ibuNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemantauanMingguanIbuNifas(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pemeriksaanNifas: Boolean? = false,
    val konsumsiVitaminA: Boolean? = false,
    val konsumsiTabletTambahDarah: Boolean? = false,
    val pemenuhanGiziSesuaiKebutuhan: Boolean? = false,
)
