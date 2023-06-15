package com.masdiq.model.pemantauanIbu.ibuHamil

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemantauanHarianIbuHamil(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pemenuhanGiziSesuaiKebutuhan: Boolean? = false,
    val demamLebihDariDuaHari: Boolean? = false,
    val sulitTidur: Boolean? = false,
    val cemasBerlebih: Boolean? = false,
    val jantungBerdebarDebar: Boolean? = false,
    val risikoTB: Boolean? = false,
    val gerakanJanin: Boolean? = false,
    val nyeriPerutHebat: Boolean? = false,
    val keluarCairanDariJalanLahir: Boolean? = false,
    val sakitSaatKencing: Boolean? = false,
    val diareBerulang: Boolean? = false,
)
