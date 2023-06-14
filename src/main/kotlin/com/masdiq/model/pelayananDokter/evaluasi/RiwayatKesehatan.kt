package com.masdiq.model.pelayananDokter.evaluasi

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class RiwayatKesehatan(
    val hipertensi: Boolean? = false,
    val asma: Boolean? = false,
    val jantung: Boolean? = false,
    val tuberculosis: Boolean? = false,
    val tiroid: Boolean? = false,
    val hepatitisB: Boolean? = false,
    val alergi: Boolean? = false,
    val jiwa: Boolean? = false,
    val autoimun: Boolean? = false,
    val sifilis: Boolean? = false,
    val diabetes: Boolean? = false,
    @BsonId
    var id: String = ObjectId().toString()
)
