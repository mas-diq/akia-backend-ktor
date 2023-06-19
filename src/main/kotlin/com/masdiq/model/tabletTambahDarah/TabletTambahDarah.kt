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
    val bulan1: Int? = 0,
    val bulan2: Int? = 0,
    val bulan3: Int? = 0,
    val bulan4: Int? = 0,
    val bulan5: Int? = 0,
    val bulan6: Int? = 0,
    val bulan7: Int? = 0,
    val bulan8: Int? = 0,
    val bulan9: Int? = 0,
    val catatanPelayanan: CatatanPelayanan,
)
