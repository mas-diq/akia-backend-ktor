package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PerilakuBeresiko
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPerilakuBeresiko = DATABASE.getCollection<PerilakuBeresiko>()

class PerilakuBeresikoImplement : PerilakuBeresikoRepository {
    override suspend fun getAllPerilakuBeresiko(): List<PerilakuBeresiko> {
        return colPerilakuBeresiko.find().toList()
    }

    override suspend fun getPerilakuBeresiko(reqId: String): PerilakuBeresiko? {
        return colPerilakuBeresiko.findOneById(reqId)
    }

    override suspend fun createOrUpdatePerilakuBeresiko(perilakuBeresiko: PerilakuBeresiko): Boolean {
        val dataFound = colPerilakuBeresiko.findOneById(perilakuBeresiko.id) != null

        return if (dataFound) {
            colPerilakuBeresiko.updateOneById(perilakuBeresiko.id, perilakuBeresiko).wasAcknowledged()
        } else {
            perilakuBeresiko.id = ObjectId().toString()
            colPerilakuBeresiko.insertOne(perilakuBeresiko).wasAcknowledged()
        }
    }

    override suspend fun deletePerilakuBeresiko(reqId: String): Boolean {
        val dataDelete = colPerilakuBeresiko.findOne(PerilakuBeresiko::id eq reqId)
        dataDelete?.let { data ->
            return colPerilakuBeresiko.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }
}