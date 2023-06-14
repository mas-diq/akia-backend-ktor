package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.StatusImunisasi

interface StatusImunisasiRepository {
    suspend fun getStatusImunisasi(reqId: String): StatusImunisasi?

    suspend fun createOrUpdateStatusImunisasi(statusImunisasi: StatusImunisasi): Boolean

    suspend fun deleteStatusImunisasi(reqId: String): Boolean
}