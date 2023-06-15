package com.masdiq.repository.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.RencanaKonsultasiLanjut

interface RencanaKonsultasiLanjutRepository {
    suspend fun getAllRencanaKonsultasiLanjut(): List<RencanaKonsultasiLanjut>

    suspend fun getRencanaKonsultasiLanjut(reqId: String): RencanaKonsultasiLanjut?

    suspend fun createOrUpdateRencanaKonsultasiLanjut(rencanaKonsultasiLanjut: RencanaKonsultasiLanjut): Boolean

    suspend fun deleteRencanaKonsultasiLanjut(reqId: String): Boolean
}