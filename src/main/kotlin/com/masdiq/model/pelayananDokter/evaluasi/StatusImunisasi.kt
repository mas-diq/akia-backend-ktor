package com.masdiq.model.pelayananDokter.evaluasi

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class StatusImunisasi(
    // toksoid tetanus
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pelayananDokter: PelayananDokter? = null,
    val tt1: Boolean? = false,
    val tt2: Boolean? = false,
    val tt3: Boolean? = false,
    val tt4: Boolean? = false,
    val tt5: Boolean? = false,
    val catatanPelayanan: CatatanPelayanan,
)
