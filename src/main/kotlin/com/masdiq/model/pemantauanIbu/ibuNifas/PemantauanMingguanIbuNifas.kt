package com.masdiq.model.pemantauanIbu.ibuNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemantauanMingguanIbuNifas(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pemeriksaanNifas: Boolean? = false,
    val konsumsiVitaminA: Boolean? = false,
    val konsumsiTabletTambahDarah: Boolean? = false,
    val pemenuhanGiziSesuaiKebutuhan: Boolean? = false,
)
