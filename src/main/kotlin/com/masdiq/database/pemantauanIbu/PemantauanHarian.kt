package com.masdiq.database.pemantauanIbu

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class PemantauanHarian(
    val PemenuhanGiziSesuaiKebutuhan: Boolean? = false,
    val DemamLebihDariDuaHari: Boolean? = false,
    val SulitTidur: Boolean? = false,
    val CemasBerlebih: Boolean? = false,
    val JantungBerdebarDebar: Boolean? = false,
    val RisikoTB: Boolean? = false,
    val GerakanJanin: Boolean? = false,
    val NyeriPerutHebat: Boolean? = false,
    val KeluarCairanDariJalanLahir: Boolean? = false,
    val SakitSaatKencing: Boolean? = false,
    val DiareBerulang: Boolean? = false,
    @BsonId
    val id: String = ObjectId().toString()
)
