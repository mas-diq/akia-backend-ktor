package com.masdiq.repository.pelayananDokter.trimester1

import com.masdiq.model.pelayananDokter.trimester1.UsgTrimester1
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colUsgTrimester1 = DATABASE.getCollection<UsgTrimester1>()

class UsgTrimester1Implement : UsgTrimester1Repository {
    override suspend fun getAllUsgTrimester1(): List<UsgTrimester1> {
        return colUsgTrimester1.find().toList()
    }

    override suspend fun getUsgTrimester1(reqId: String): UsgTrimester1? {
        return colUsgTrimester1.findOneById(reqId)
    }

    override suspend fun createOrUpdateUsgTrimester1(usgTrimester1: UsgTrimester1): Boolean {
        val dataFound = colUsgTrimester1.findOneById(usgTrimester1.id) != null

        return if (dataFound) {
            colUsgTrimester1.updateOneById(usgTrimester1.id, usgTrimester1).wasAcknowledged()
        } else {
            usgTrimester1.id = ObjectId().toString()
            colUsgTrimester1.insertOne(usgTrimester1).wasAcknowledged()
        }
    }

    override suspend fun deleteUsgTrimester1(reqId: String): Boolean {
        val dataDelete = colUsgTrimester1.findOne(UsgTrimester1::id eq reqId)
        dataDelete?.let { data ->
            return colUsgTrimester1.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchUsgTrimester1(reqId: String): List<UsgTrimester1> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colUsgTrimester1.find(UsgTrimester1::userId eq reqId).toList()
        }
    }
}