package com.masdiq.repository.persalinanIbu.pelayananNifas

import com.masdiq.model.persalinanIbu.pelayananNifas.KesimpulanAkhirNifas

interface KesimpulanAkhirNifasRepository {
    suspend fun getAllKesimpulanAkhirNifas(): List<KesimpulanAkhirNifas>

    suspend fun getKesimpulanAkhirNifas(reqId: String): KesimpulanAkhirNifas?

    suspend fun createOrUpdateKesimpulanAkhirNifas(kesimpulanAkhirNifas: KesimpulanAkhirNifas): Boolean

    suspend fun deleteKesimpulanAkhirNifas(reqId: String): Boolean
    suspend fun searchKesimpulanAkhirNifas(reqId: String): List<KesimpulanAkhirNifas>
}