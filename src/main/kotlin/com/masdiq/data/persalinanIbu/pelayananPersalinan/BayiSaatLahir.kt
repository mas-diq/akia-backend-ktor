package com.masdiq.data.persalinanIbu.pelayananPersalinan

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class BayiSaatLahir(
    val anakKe: Int? = 1,
    val beratLahir: Int? = 0,
    val panjangBadan: Int? = 0,
    val lingkarKepala: Int? = 0,
    val jenisKelamin: Boolean? = true,
    val kondisiSaatLahir: String? = "Kosong",
    val asuhanBayiBaruLahir: String? = "Kosong",
    val keteranganTambahan: String? = "Kosong",
    @BsonId
    val id: String = ObjectId().toString()
)
