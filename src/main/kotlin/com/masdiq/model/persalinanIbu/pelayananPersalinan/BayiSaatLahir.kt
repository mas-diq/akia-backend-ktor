package com.masdiq.model.persalinanIbu.pelayananPersalinan

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class BayiSaatLahir(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val anakKe: Int? = 1,
    val beratLahir: Int? = 0,
    val panjangBadan: Int? = 0,
    val lingkarKepala: Int? = 0,
    val jenisKelamin: String? = "Laki-laki",
    val kondisiSaatLahir: String? = "Hidup",
    val asuhanBayiBaruLahir: String? = "Ibu",
    val keteranganTambahan: String? = "Kosong",
    val catatanPelayanan: CatatanPelayanan,
)
