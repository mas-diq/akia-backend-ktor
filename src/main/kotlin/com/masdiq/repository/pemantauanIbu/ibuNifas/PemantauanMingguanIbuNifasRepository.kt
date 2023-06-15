package com.masdiq.repository.pemantauanIbu.ibuNifas

import com.masdiq.model.pemantauanIbu.ibuNifas.PemantauanMingguanIbuNifas

interface PemantauanMingguanIbuNifasRepository {
    suspend fun getAllPemantauanMingguanIbuNifas(): List<PemantauanMingguanIbuNifas>

    suspend fun getPemantauanMingguanIbuNifas(reqId: String): PemantauanMingguanIbuNifas?

    suspend fun createOrUpdatePemantauanMingguanIbuNifas(pemantauanMingguanIbuNifas: PemantauanMingguanIbuNifas): Boolean

    suspend fun deletePemantauanMingguanIbuNifas(reqId: String): Boolean
}