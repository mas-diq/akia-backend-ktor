package com.masdiq.repository.pemantauanIbu.ibuNifas

import com.masdiq.model.pemantauanIbu.ibuNifas.PemantauanHarianIbuNifas

interface PemantauanHarianIbuNifasRepository {
    suspend fun getAllPemantauanHarianIbuNifas(): List<PemantauanHarianIbuNifas>

    suspend fun getPemantauanHarianIbuNifas(reqId: String): PemantauanHarianIbuNifas?

    suspend fun createOrUpdatePemantauanHarianIbuNifas(pemantauanHarianIbuNifas: PemantauanHarianIbuNifas): Boolean

    suspend fun deletePemantauanHarianIbuNifas(reqId: String): Boolean
    suspend fun searchPemantauanHarianIbuNifas(reqId: String): List<PemantauanHarianIbuNifas>
}