package com.masdiq.model.pelayananDokter.evaluasi

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class PerilakuBeresiko(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val merokok: Boolean? = false,
    val polaMakan: Boolean? = false,
    val aktifitasFisik: Boolean? = false,
    val alkohol: Boolean? = false,
    val obatTeratogenik: Boolean? = false,
    val kosmetikBerbahaya: Boolean? = false,
    val catatanPelayanan: CatatanPelayanan,
)