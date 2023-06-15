package com.masdiq.model.tabletTambahDarah

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class TabletTambahDarah(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
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
