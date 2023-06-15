package com.masdiq.model.pelayananDokter

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemeriksaanFisik(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pelayananDokter: PelayananDokter? = null,
    val keadaanUmum: Boolean? = true,
    val konjungtiva: Boolean? = true,
    val sklera: Boolean? = true,
    val kulit: Boolean? = true,
    val leher: Boolean? = true,
    val gigi: Boolean? = true,
    val mulut: Boolean? = true,
    val tht: Boolean? = true,
    val dada: Boolean? = true,
    val paru: Boolean? = true,
    val perut: Boolean? = true,
    val tungkai: Boolean? = true,
    val catatanPelayanan: CatatanPelayanan,
)