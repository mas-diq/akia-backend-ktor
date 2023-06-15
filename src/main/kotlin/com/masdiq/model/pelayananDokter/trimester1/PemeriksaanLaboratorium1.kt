package com.masdiq.model.pelayananDokter.trimester1

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PemeriksaanLaboratorium1(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val hemoglobin: Int? = 0,
    val golonganDarah: String? = "A",
    val gulaDarahSewaktu: Int? = 0,
    val ppia: Boolean? = true,
    val catatanPelayanan: CatatanPelayanan,
)
