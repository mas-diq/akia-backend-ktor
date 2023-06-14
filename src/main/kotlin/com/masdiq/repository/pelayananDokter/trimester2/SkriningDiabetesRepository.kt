package com.masdiq.repository.pelayananDokter.trimester2

import com.masdiq.model.pelayananDokter.trimester2.SkriningDiabetes

interface SkriningDiabetesRepository {
    suspend fun getSkriningDiabetes(reqId: String): SkriningDiabetes?

    suspend fun createOrUpdateSkriningDiabetes(skriningDiabetes: SkriningDiabetes): Boolean

    suspend fun deleteSkriningDiabetes(reqId: String): Boolean
}