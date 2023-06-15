package com.masdiq.model.persalinanIbu.pelayananPersalinan

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class IbuBersalinDanIbuNifas(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val tanggalPersalinan: String? = "2000-00-00",
    val waktuPersalinan: String? = "00:00",
    val umurKehamilan: Int? = 0,
    val penolongPersalinan: String? = "Kosong",
    val caraPersalinan: String? = "Kosong",
    val keadaanIbu: String? = "Kosong",
    val kBPascaPersalinan: Boolean? = true,
    val keteranganTambahan: String? = "Kosong",
    val catatanPelayanan: CatatanPelayanan,
)