package com.masdiq.repository.pelayananDokter

import com.masdiq.model.pelayananDokter.PemeriksaanFisik

interface PemeriksaanFisikRepository {
    suspend fun getAllPemeriksaanFisik(): List<PemeriksaanFisik>

    suspend fun getPemeriksaanFisik(reqId: String): PemeriksaanFisik?

    suspend fun createOrUpdatePemeriksaanFisik(riwayatKesehatan: PemeriksaanFisik): Boolean

    suspend fun deletePemeriksaanFisik(reqId: String): Boolean
    suspend fun searchPemeriksaanFisik(reqId: String): List<PemeriksaanFisik>
}