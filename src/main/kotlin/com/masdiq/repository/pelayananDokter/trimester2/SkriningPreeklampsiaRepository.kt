package com.masdiq.repository.pelayananDokter.trimester2

import com.masdiq.model.pelayananDokter.trimester2.SkriningPreeklampsia

interface SkriningPreeklampsiaRepository {
    suspend fun getSkriningPreeklampsia(reqId: String): SkriningPreeklampsia?

    suspend fun createOrUpdateSkriningPreeklampsia(skriningPreeklampsia: SkriningPreeklampsia): Boolean

    suspend fun deleteSkriningPreeklampsia(reqId: String): Boolean
}