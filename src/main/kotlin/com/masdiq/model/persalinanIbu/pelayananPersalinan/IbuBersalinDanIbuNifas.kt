package com.masdiq.model.persalinanIbu.pelayananPersalinan

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class IbuBersalinDanIbuNifas(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val tanggalPersalinan: String? = LocalDate.now().toString(),
    val waktuPersalinan: String? = LocalDateTime.now().toString(),
    val umurKehamilan: Int? = 0,
    val penolongPersalinan: String? = "Kosong",
    val caraPersalinan: String? = "Kosong",
    val keadaanIbu: String? = "Kosong",
    val kBPascaPersalinan: Boolean? = true,
    val keteranganTambahan: String? = "Kosong",
    val catatanPelayanan: CatatanPelayanan,
)