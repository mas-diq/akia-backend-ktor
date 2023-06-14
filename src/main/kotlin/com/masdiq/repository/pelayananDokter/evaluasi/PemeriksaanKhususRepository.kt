package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PemeriksaanKhusus

interface PemeriksaanKhususRepository {
    suspend fun getPemeriksaanKhususRepository(reqId: String): PemeriksaanKhusus?

    suspend fun createOrUpdatePemeriksaanKhususRepository(pemeriksaanKhusus: PemeriksaanKhusus): Boolean

    suspend fun deletePemeriksaanKhususRepository(reqId: String): Boolean
}