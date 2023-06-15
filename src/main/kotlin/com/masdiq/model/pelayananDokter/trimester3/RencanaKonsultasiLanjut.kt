package com.masdiq.model.pelayananDokter.trimester3

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class RencanaKonsultasiLanjut(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val gizi: Boolean? = false,
    val kebidanan: Boolean? = false,
    val anak: Boolean? = false,
    val penyakitDalam: Boolean? = false,
    val neurologi: Boolean? = false,
    val tht: Boolean? = false,
    val psikiatri: Boolean? = false,
    val catatanPelayanan: CatatanPelayanan,
)
