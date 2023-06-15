package com.masdiq.model.pemantauanIbu.ibuNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemantauanHarianIbuNifas(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val kesehatanJiwa: Boolean? = false,
    val demam: Boolean? = false,
    val sakitKepala: Boolean? = false,
    val pandanganKabur: Boolean? = false,
    val nyeriUluHati: Boolean? = false,
    val jantungBerdebar: Boolean? = false,
    val keluarCarianDariJalanLahir: Boolean? = false,
    val nafasPendekDanTerengah: Boolean? = false,
    val payudara: Boolean? = false,
    val buahAirKecil: Boolean? = false,
    val areaSekitarKelamin: Boolean? = false,
    val darahNifas: Boolean? = false,
    val pendarahan: Boolean? = false,
    val keputihan: Boolean? = false,
)
