package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.KondisiKesehatan

interface KondisiKesehatanRepository {
    suspend fun getAllKondisiKesehatan(): List<KondisiKesehatan>

    suspend fun getKondisiKesehatan(reqId: String): KondisiKesehatan?

    suspend fun createOrUpdateKondisiKesehatan(kondisiKesehatan: KondisiKesehatan): Boolean

    suspend fun deleteKondisiKesehatan(reqId: String): Boolean
    suspend fun searchKondisiKesehatan(reqId: String): List<KondisiKesehatan>
}