package com.masdiq.repository.persalinanIbu.pelayananNifas

import com.masdiq.model.persalinanIbu.pelayananNifas.KunjunganNifas

class KunjunganNifasImplement : KunjunganNifasRepository{
    override suspend fun getKunjunganNifas(reqId: String): KunjunganNifas? {
        TODO("Not yet implemented")
    }

    override suspend fun createOrUpdateKunjunganNifas(kunjunganNifas: KunjunganNifas): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteKunjunganNifas(reqId: String): Boolean {
        TODO("Not yet implemented")
    }

}