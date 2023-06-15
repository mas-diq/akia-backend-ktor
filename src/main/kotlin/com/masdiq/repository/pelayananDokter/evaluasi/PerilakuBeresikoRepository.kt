package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PerilakuBeresiko

interface PerilakuBeresikoRepository {
    suspend fun getAllPerilakuBeresiko(): List<PerilakuBeresiko>

    suspend fun getPerilakuBeresiko(reqId: String): PerilakuBeresiko?

    suspend fun createOrUpdatePerilakuBeresiko(perilakuBeresiko: PerilakuBeresiko): Boolean

    suspend fun deletePerilakuBeresiko(reqId: String): Boolean
}