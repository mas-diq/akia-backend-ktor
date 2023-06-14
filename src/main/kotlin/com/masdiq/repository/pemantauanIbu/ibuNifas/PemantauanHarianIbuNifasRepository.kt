package com.masdiq.repository.pemantauanIbu.ibuNifas

import com.masdiq.model.pemantauanIbu.ibuNifas.PemantauanHarianIbuNifas

interface PemantauanHarianIbuNifasRepository {
    suspend fun getPemantauanHarianIbuNifas(reqId: String): PemantauanHarianIbuNifas?

    suspend fun createOrUpdatePemantauanHarianIbuNifas(pemantauanHarianIbuNifas: PemantauanHarianIbuNifas): Boolean

    suspend fun deletePemantauanHarianIbuNifas(reqId: String): Boolean
}