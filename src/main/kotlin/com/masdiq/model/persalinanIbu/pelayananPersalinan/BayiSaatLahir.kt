package com.masdiq.model.persalinanIbu.pelayananPersalinan

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class BayiSaatLahir(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val anakKe: Int? = 1,
    val beratLahir: Int? = 0,
    val panjangBadan: Int? = 0,
    val lingkarKepala: Int? = 0,
    val jenisKelamin: Boolean? = true,
    val kondisiSaatLahir: String? = "Kosong",
    val asuhanBayiBaruLahir: String? = "Kosong",
    val keteranganTambahan: String? = "Kosong",
    val catatanPelayanan: CatatanPelayanan,
)
