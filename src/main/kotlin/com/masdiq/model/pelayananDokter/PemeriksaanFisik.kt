package com.masdiq.model.pelayananDokter

import com.masdiq.model.CatatanPelayanan
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemeriksaanFisik(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
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
