package com.masdiq.repository.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.UsgTrimester3
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colUsgTrimester3 = DATABASE.getCollection<UsgTrimester3>()

class UsgTrimester3Implement : UsgTrimester3Repository {
    override suspend fun getAllUsgTrimester3(): List<UsgTrimester3> {
        return colUsgTrimester3.find().toList()
    }

    override suspend fun getUsgTrimester3(reqId: String): UsgTrimester3? {
        return colUsgTrimester3.findOneById(reqId)
    }

    override suspend fun createOrUpdateUsgTrimester3(usgTrimester3: UsgTrimester3): Boolean {
        val dataFound = colUsgTrimester3.findOneById(usgTrimester3.id) != null

        return if (dataFound) {
            colUsgTrimester3.updateOneById(usgTrimester3.id, usgTrimester3).wasAcknowledged()
        } else {
            usgTrimester3.id = ObjectId().toString()
            colUsgTrimester3.insertOne(usgTrimester3).wasAcknowledged()
        }
    }

    override suspend fun deleteUsgTrimester3(reqId: String): Boolean {
        val dataDelete = colUsgTrimester3.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colUsgTrimester3.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}