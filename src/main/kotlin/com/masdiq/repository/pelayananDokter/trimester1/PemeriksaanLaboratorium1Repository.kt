package com.masdiq.repository.pelayananDokter.trimester1

import com.masdiq.model.pelayananDokter.trimester1.PemeriksaanLaboratorium1

interface PemeriksaanLaboratorium1Repository {
    suspend fun getPemeriksaanLaboratorium1(reqId: String): PemeriksaanLaboratorium1?

    suspend fun createOrUpdatePemeriksaanLaboratorium1(pemeriksaanLaboratorium1: PemeriksaanLaboratorium1): Boolean

    suspend fun deletePemeriksaanLaboratorium1(reqId: String): Boolean
}