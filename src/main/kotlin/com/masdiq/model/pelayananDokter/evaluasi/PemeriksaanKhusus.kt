package com.masdiq.model.pelayananDokter.evaluasi

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PemeriksaanKhusus(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val inspeksi: Boolean? = false,
    val inspekulo: Boolean? = false,
    val vulva: Boolean? = false,
    val uretra: Boolean? = false,
    val vagina: Boolean? = false,
    val fluksus: Boolean? = false,
    val fluour: Boolean? = false,
    val posio: Boolean? = false,
    val catatanPelayanan: CatatanPelayanan,
)
