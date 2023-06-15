package com.masdiq.model.pelayananDokter.evaluasi

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class KondisiKesehatan(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val tinggiBadan: Int? = 0,
    val beratBadan: Int? = 0,
    val lingkarLengan: Int? = 0,
    val imt: Double? = 0.0,
    val catatanPelayanan: CatatanPelayanan,
)
