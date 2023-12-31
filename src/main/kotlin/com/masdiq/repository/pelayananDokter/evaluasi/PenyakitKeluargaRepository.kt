package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PenyakitKeluarga

interface PenyakitKeluargaRepository {
    suspend fun getAllPenyakitKeluarga(): List<PenyakitKeluarga>

    suspend fun getPenyakitKeluarga(reqId: String): PenyakitKeluarga?

    suspend fun createOrUpdatePenyakitKeluarga(penyakitKeluarga: PenyakitKeluarga): Boolean

    suspend fun deleteTabletPenyakitKeluarga(reqId: String): Boolean
    suspend fun searchPenyakitKeluarga(reqId: String): List<PenyakitKeluarga>
}