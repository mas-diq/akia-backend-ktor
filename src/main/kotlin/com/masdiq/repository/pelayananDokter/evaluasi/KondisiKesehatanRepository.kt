package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.KondisiKesehatan

interface KondisiKesehatanRepository {
    suspend fun getKondisiKesehatan(reqId: String): KondisiKesehatan?

    suspend fun createOrUpdateKondisiKesehatan(kondisiKesehatan: KondisiKesehatan): Boolean

    suspend fun deleteKondisiKesehatan(reqId: String): Boolean
}