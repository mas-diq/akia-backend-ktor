package com.masdiq.database.pelayananDokter.trimester2

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class SkriningPreeklampsia(
    val anamnesis: Boolean? = false,
    val multiparaPasanganBaru: Boolean? = false,
    val kehamilanTeknologi: Boolean? = false,
    val umurLebihDari35: Boolean? = false,
    val nulipara: Boolean? = false,
    val multiparaLebih10Tahun: Boolean? = false,
    val riwayatPreeklampsia: Boolean? = false,
    val obesitas: Boolean? = false,
    val multiparaPreeklampsia: Boolean? = false,
    val kehamilanMultiple: Boolean? = false,
    val diabetesKehamilan: Boolean? = false,
    val hipertensiKronik: Boolean? = false,
    val ginjal: Boolean? = false,
    val autoimun: Boolean? = false,
    val antiPhospholipid: Boolean? = false,
    val pemeriksaanFisik: Boolean? = false,
    val meanArterialPreasure: Boolean? = false,
    val proteinuria: Boolean? = false,
    @BsonId
    val id: String = ObjectId().toString()
)
