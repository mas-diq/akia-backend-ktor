package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.StatusImunisasi

interface StatusImunisasiRepository {
    suspend fun getAllStatusImunisasi(): List<StatusImunisasi>

    suspend fun getStatusImunisasi(reqId: String): StatusImunisasi?

    suspend fun createOrUpdateStatusImunisasi(statusImunisasi: StatusImunisasi): Boolean

    suspend fun deleteStatusImunisasi(reqId: String): Boolean
    suspend fun searchStatusImunisasi(reqId: String): List<StatusImunisasi>
}