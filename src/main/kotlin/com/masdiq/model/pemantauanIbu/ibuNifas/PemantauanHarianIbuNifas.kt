package com.masdiq.model.pemantauanIbu.ibuNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemantauanHarianIbuNifas(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
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
