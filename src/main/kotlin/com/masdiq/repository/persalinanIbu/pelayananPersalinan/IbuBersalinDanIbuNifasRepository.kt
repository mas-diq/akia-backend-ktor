package com.masdiq.repository.persalinanIbu.pelayananPersalinan

import com.masdiq.model.persalinanIbu.pelayananPersalinan.IbuBersalinDanIbuNifas

interface IbuBersalinDanIbuNifasRepository {
    suspend fun getAllIbuBersalinDanIbuNifas(): List<IbuBersalinDanIbuNifas>

    suspend fun getIbuBersalinDanIbuNifas(reqId: String): IbuBersalinDanIbuNifas?

    suspend fun createOrUpdateIbuBersalinDanIbuNifas(ibuBersalinDanIbuNifas: IbuBersalinDanIbuNifas): Boolean

    suspend fun deleteIbuBersalinDanIbuNifas(reqId: String): Boolean
    suspend fun searchIbuBersalinDanIbuNifas(reqId: String): List<IbuBersalinDanIbuNifas>
}