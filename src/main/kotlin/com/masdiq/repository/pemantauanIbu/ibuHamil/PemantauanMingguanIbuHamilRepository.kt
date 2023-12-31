package com.masdiq.repository.pemantauanIbu.ibuHamil

import com.masdiq.model.pemantauanIbu.ibuHamil.PemantauanMingguanIbuHamil

interface PemantauanMingguanIbuHamilRepository {
    suspend fun getAllPemantauanMingguanIbuHamil(): List<PemantauanMingguanIbuHamil>

    suspend fun getPemantauanMingguanIbuHamil(reqId: String): PemantauanMingguanIbuHamil?

    suspend fun createOrUpdatePemantauanMingguanIbuHamil(pemantauanMingguanIbuHamil: PemantauanMingguanIbuHamil): Boolean

    suspend fun deletePemantauanMingguanIbuHamil(reqId: String): Boolean
    suspend fun searchPemantauanMingguanIbuHamil(reqId: String): List<PemantauanMingguanIbuHamil>
}