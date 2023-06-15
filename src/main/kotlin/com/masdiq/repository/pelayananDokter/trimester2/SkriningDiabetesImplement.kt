package com.masdiq.repository.pelayananDokter.trimester2

import com.masdiq.model.pelayananDokter.trimester2.SkriningDiabetes
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colSkriningDiabetes = DATABASE.getCollection<SkriningDiabetes>()

class SkriningDiabetesImplement : SkriningDiabetesRepository {
    override suspend fun getAllSkriningDiabetes(): List<SkriningDiabetes> {
        return colSkriningDiabetes.find().toList()
    }

    override suspend fun getSkriningDiabetes(reqId: String): SkriningDiabetes? {
        return colSkriningDiabetes.findOneById(reqId)
    }

    override suspend fun createOrUpdateSkriningDiabetes(skriningDiabetes: SkriningDiabetes): Boolean {
        val dataFound = colSkriningDiabetes.findOneById(skriningDiabetes.id) != null

        return if (dataFound) {
            colSkriningDiabetes.updateOneById(skriningDiabetes.id, skriningDiabetes).wasAcknowledged()
        } else {
            skriningDiabetes.id = ObjectId().toString()
            colSkriningDiabetes.insertOne(skriningDiabetes).wasAcknowledged()
        }
    }

    override suspend fun deleteSkriningDiabetes(reqId: String): Boolean {
        val dataDelete = colSkriningDiabetes.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colSkriningDiabetes.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}