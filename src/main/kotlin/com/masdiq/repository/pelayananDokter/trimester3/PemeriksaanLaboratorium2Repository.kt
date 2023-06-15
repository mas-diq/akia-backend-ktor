package com.masdiq.repository.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.PemeriksaanLaboratorium2

interface PemeriksaanLaboratorium2Repository {
    suspend fun getAllPemeriksaanLaboratorium2(): List<PemeriksaanLaboratorium2>

    suspend fun getPemeriksaanLaboratorium2(reqId: String): PemeriksaanLaboratorium2?

    suspend fun createOrUpdatePemeriksaanLaboratorium2(pemeriksaanLaboratorium2: PemeriksaanLaboratorium2): Boolean

    suspend fun deletePemeriksaanLaboratorium2(reqId: String): Boolean
}