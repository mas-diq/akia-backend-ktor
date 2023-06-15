package com.masdiq.model.pelayananDokter.trimester3

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class RencanaPersalinanDanKb(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val normal: Boolean? = false,
    val pervaginam: Boolean? = false,
    val sectioCaesaria: Boolean? = false,
    val mal: Boolean? = false,
    val pil: Boolean? = false,
    val akdr: Boolean? = false,
    val implan: Boolean? = false,
    val steril: Boolean? = false,
    val belumMemilih: Boolean? = false,
    val konseling: Boolean? = false,
    val catatanPelayanan: CatatanPelayanan,
)
