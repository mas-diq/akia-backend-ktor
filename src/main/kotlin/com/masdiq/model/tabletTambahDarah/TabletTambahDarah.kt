package com.masdiq.model.tabletTambahDarah

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class TabletTambahDarah(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val bulan1: Boolean? = false,
    val bulan2: Boolean? = false,
    val bulan3: Boolean? = false,
    val bulan4: Boolean? = false,
    val bulan5: Boolean? = false,
    val bulan6: Boolean? = false,
    val bulan7: Boolean? = false,
    val bulan8: Boolean? = false,
    val bulan9: Boolean? = false,
    val catatanPelayanan: CatatanPelayanan,
)
