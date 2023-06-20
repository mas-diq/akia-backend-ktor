package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PemeriksaanKhusus

interface PemeriksaanKhususRepository {
    suspend fun getAllPemeriksaanKhusus(): List<PemeriksaanKhusus>

    suspend fun getPemeriksaanKhusus(reqId: String): PemeriksaanKhusus?

    suspend fun createOrUpdatePemeriksaanKhusus(pemeriksaanKhusus: PemeriksaanKhusus): Boolean

    suspend fun deletePemeriksaanKhusus(reqId: String): Boolean
    suspend fun searchPemeriksaanKhusus(reqId: String): List<PemeriksaanKhusus>
}