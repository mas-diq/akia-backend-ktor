package com.masdiq.model.persalinanIbu.pelayananNifas

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class KunjunganNifas(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val namaDokter: String? = "Kosong",
    val namaFaskes: String? = "Kosong",
    val kunjunganNifasKe: Int? = 0,
    val klarifikasi: String? = "Kosong",
    val tindakan: String? = "Kosong",
    val catatanPelayanan: CatatanPelayanan,
)
