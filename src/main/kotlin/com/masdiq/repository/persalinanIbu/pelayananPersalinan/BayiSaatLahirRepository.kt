package com.masdiq.repository.persalinanIbu.pelayananPersalinan

import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir

interface BayiSaatLahirRepository {
    suspend fun getAllBayiSaatLahir(): List<BayiSaatLahir>

    suspend fun getBayiSaatLahir(reqId: String): BayiSaatLahir?

    suspend fun createOrUpdateBayiSaatLahir(bayiSaatLahir: BayiSaatLahir): Boolean

    suspend fun deleteBayiSaatLahir(reqId: String): Boolean
    suspend fun searchBayiSaatLahir(reqId: String): List<BayiSaatLahir>
}