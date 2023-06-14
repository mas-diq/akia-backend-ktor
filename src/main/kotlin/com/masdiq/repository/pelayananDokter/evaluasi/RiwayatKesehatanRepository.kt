package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.RiwayatKesehatan

interface RiwayatKesehatanRepository {
    suspend fun getRiwayatKesehatan(reqId: String): RiwayatKesehatan?

    suspend fun createOrUpdateRiwayatKesehatan(riwayatKesehatan: RiwayatKesehatan): Boolean

    suspend fun deleteRiwayatKesehatan(reqId: String): Boolean
}