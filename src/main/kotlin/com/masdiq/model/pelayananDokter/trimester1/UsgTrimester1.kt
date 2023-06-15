package com.masdiq.model.pelayananDokter.trimester1

import com.masdiq.model.CatatanPelayanan
import com.masdiq.model.KesimpulanDanRekomendasi
import com.masdiq.model.pelayananDokter.PelayananDokter
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class UsgTrimester1(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val tanggal: String? = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE).toString().trim(),
    val jam: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString().trim(),
    val pelayananDokter: PelayananDokter? = null,
    val keadaanUmum: Boolean? = true,
    val gestationalSac: Int? = 0,
    val CrownrumpLength: Int? = 0,
    val DenyutJantungJanin: Int? = 0,
    val usiaKehamilan: Int? = 0,
    val letakKantongKehamilan: String? = "Intauterin",
    val taksiranPersalinan: Int = 0,
    val catatanPelayanan: CatatanPelayanan,
)
