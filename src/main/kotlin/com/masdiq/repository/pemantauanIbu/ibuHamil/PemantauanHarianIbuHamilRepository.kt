package com.masdiq.repository.pemantauanIbu.ibuHamil

import com.masdiq.model.pemantauanIbu.ibuHamil.PemantauanHarianIbuHamil

interface PemantauanHarianIbuHamilRepository {
    suspend fun getAllPemantauanHarianIbuHamil(): List<PemantauanHarianIbuHamil>

    suspend fun getPemantauanHarianIbuHamil(reqId: String): PemantauanHarianIbuHamil?

    suspend fun createOrUpdatePemantauanHarianIbuHamil(pemantauanHarianIbuHamil: PemantauanHarianIbuHamil): Boolean

    suspend fun deletePemantauanHarianIbuHamil(reqId: String): Boolean
    suspend fun searchPemantauanHarianIbuHamil(reqId: String): List<PemantauanHarianIbuHamil>
}