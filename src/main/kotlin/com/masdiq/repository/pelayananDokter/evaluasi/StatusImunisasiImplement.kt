package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.StatusImunisasi

class StatusImunisasiImplement : StatusImunisasiRepository {
    override suspend fun getStatusImunisasi(reqId: String): StatusImunisasi? {
        TODO("Not yet implemented")
    }

    override suspend fun createOrUpdateStatusImunisasi(statusImunisasi: StatusImunisasi): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStatusImunisasi(reqId: String): Boolean {
        TODO("Not yet implemented")
    }

}