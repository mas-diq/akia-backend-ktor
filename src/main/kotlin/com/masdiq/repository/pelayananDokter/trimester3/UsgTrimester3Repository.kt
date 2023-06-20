package com.masdiq.repository.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.UsgTrimester3

interface UsgTrimester3Repository {
    suspend fun getAllUsgTrimester3(): List<UsgTrimester3>

    suspend fun getUsgTrimester3(reqId: String): UsgTrimester3?

    suspend fun createOrUpdateUsgTrimester3(usgTrimester3: UsgTrimester3): Boolean

    suspend fun deleteUsgTrimester3(reqId: String): Boolean
    suspend fun searchUsgTrimester3(reqId: String): List<UsgTrimester3>
}