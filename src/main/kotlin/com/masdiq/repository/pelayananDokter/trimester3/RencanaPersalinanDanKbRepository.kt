package com.masdiq.repository.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.RencanaPersalinanDanKb

interface RencanaPersalinanDanKbRepository {
    suspend fun getAllRencanaPersalinanDanKb(): List<RencanaPersalinanDanKb>

    suspend fun getRencanaPersalinanDanKb(reqId: String): RencanaPersalinanDanKb?

    suspend fun createOrUpdateRencanaPersalinanDanKb(rencanaPersalinanDanKb: RencanaPersalinanDanKb): Boolean

    suspend fun deleteRencanaPersalinanDanKb(reqId: String): Boolean
    suspend fun searchRencanaPersalinanDanKb(reqId: String): List<RencanaPersalinanDanKb>
}