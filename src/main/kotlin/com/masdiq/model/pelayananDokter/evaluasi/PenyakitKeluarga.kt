package com.masdiq.model.pelayananDokter.evaluasi

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PenyakitKeluarga(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pelayananDokter: PelayananDokter? = null,
    val hipertensi: Boolean? = false,
    val asma: Boolean? = false,
    val jantung: Boolean? = false,
    val tuberculosis: Boolean? = false,
    val tiroid: Boolean? = false,
    val hepatitisB: Boolean? = false,
    val alergi: Boolean? = false,
    val jiwa: Boolean? = false,
    val autoimun: Boolean? = false,
    val sifilis: Boolean? = false,
    val diabetes: Boolean? = false,
    val catatanPelayanan: CatatanPelayanan,
)