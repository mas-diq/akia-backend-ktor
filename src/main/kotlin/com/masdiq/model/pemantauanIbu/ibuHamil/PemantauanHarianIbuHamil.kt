package com.masdiq.model.pemantauanIbu.ibuHamil

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemantauanHarianIbuHamil(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
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
