package com.masdiq.model.pelayananDokter.trimester3

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class UsgTrimester3(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pelayananDokter: PelayananDokter? = null,
    val janin: Boolean? = true,
    val jumlahJanin: Boolean? = true,
    val letakJanin: Boolean? = true,
    val beratJanin: Int? = 0,
    val plasenta: Boolean? = true,
    val usiaKehamilan: Int? = 0,
    val catatanPelayanan: CatatanPelayanan,
)
