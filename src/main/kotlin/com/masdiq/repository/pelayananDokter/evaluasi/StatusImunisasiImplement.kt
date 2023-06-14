package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.StatusImunisasi
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val colStatusImunisasi = DATABASE.getCollection<StatusImunisasi>()

class StatusImunisasiImplement : StatusImunisasiRepository {
    override suspend fun getStatusImunisasi(reqId: String): StatusImunisasi? {
        return colStatusImunisasi.findOneById(reqId)
    }

    override suspend fun createOrUpdateStatusImunisasi(statusImunisasi: StatusImunisasi): Boolean {
        val dataFound = colStatusImunisasi.findOneById(statusImunisasi.id) != null

        return if (dataFound) {
            colStatusImunisasi.updateOneById(statusImunisasi.id, statusImunisasi).wasAcknowledged()
        } else {
            statusImunisasi.id = ObjectId().toString()
            colStatusImunisasi.insertOne(statusImunisasi).wasAcknowledged()
        }
    }

    override suspend fun deleteStatusImunisasi(reqId: String): Boolean {
        val dataDelete = colStatusImunisasi.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colStatusImunisasi.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}