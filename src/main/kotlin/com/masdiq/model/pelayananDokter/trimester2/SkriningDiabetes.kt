package com.masdiq.model.pelayananDokter.trimester2

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class SkriningDiabetes(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val jam: String? = "00:00",
    val pelayananDokter: PelayananDokter? = null,
    val gulaDarahPuasa: Int? = 0,
    val gulaDarahPostPrandial: Int? = 0,
    val rencanaTindakLanjut: String? = "Kosong",
    val catatanPelayanan: CatatanPelayanan,
)
