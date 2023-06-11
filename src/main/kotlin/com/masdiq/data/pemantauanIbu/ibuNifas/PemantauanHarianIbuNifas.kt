package com.masdiq.data.pemantauanIbu.ibuNifas

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PemantauanHarianIbuNifas(
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
    @BsonId
    val id: String = ObjectId().toString()
)
