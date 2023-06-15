package com.masdiq.model.pelayananDokter.evaluasi

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PerilakuBeresiko(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pelayananDokter: PelayananDokter? = null,
    val merokok: Boolean? = false,
    val polaMakan: Boolean? = false,
    val aktifitasFisik: Boolean? = false,
    val alkohol: Boolean? = false,
    val obatTeratogenik: Boolean? = false,
    val kosmetikBerbahaya: Boolean? = false,
    val catatanPelayanan: CatatanPelayanan,
)