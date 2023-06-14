package com.masdiq.repository.pelayananDokter.trimester1

import com.masdiq.model.pelayananDokter.trimester1.UsgTrimester1

interface UsgTrimester1Repository {
    suspend fun getUsgTrimester1(reqId: String): UsgTrimester1?

    suspend fun createOrUpdateUsgTrimester1(usgTrimester1: UsgTrimester1): Boolean

    suspend fun deleteUsgTrimester1(reqId: String): Boolean
}