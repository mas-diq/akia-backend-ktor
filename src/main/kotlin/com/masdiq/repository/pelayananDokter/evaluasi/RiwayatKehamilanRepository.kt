package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.RiwayatKehamilan

interface RiwayatKehamilanRepository {
    suspend fun getAllRiwayatKehamilan(): List<RiwayatKehamilan>

    suspend fun getRiwayatKehamilan(reqId: String): RiwayatKehamilan?

    suspend fun createOrUpdateRiwayatKehamilan(riwayatKehamilan: RiwayatKehamilan): Boolean

    suspend fun deleteRiwayatKehamilan(reqId: String): Boolean
}