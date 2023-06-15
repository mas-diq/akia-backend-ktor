package com.masdiq.model.persalinanIbu.pelayananNifas

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class KesimpulanAkhirNifas(
    @BsonId
    var id: String = ObjectId().toString(),
    val userId: String? = "iu0001",
    val tanggal: String? = "2000-00-00",
    val pelayananDokter: PelayananDokter? = null,
    val jam: String? = "00:00",
    val keadaanIbu: Boolean? = true,
    val keadaanBayi: Boolean? = true,
    val komplikasiNifas: Boolean? = false,
    val kesimpulan: String? = "Kosong",
    val catatanPelayanan: CatatanPelayanan,
)