package com.masdiq.model.pelayananDokter.trimester2

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class SkriningPreeklampsia(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pelayananDokter: PelayananDokter? = null,
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
    val catatanPelayanan: CatatanPelayanan,
)
