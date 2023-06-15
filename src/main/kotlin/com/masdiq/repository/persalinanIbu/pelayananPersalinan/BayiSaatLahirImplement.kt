package com.masdiq.repository.persalinanIbu.pelayananPersalinan

import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colBayiSaatLahir = DATABASE.getCollection<BayiSaatLahir>()

class BayiSaatLahirImplement : BayiSaatLahirRepository {
    override suspend fun getAllBayiSaatLahir(): List<BayiSaatLahir> {
        return colBayiSaatLahir.find().toList()
    }

    override suspend fun getBayiSaatLahir(reqId: String): BayiSaatLahir? {
        return colBayiSaatLahir.findOneById(reqId)
    }

    override suspend fun createOrUpdateBayiSaatLahir(bayiSaatLahir: BayiSaatLahir): Boolean {
        val dataFound = colBayiSaatLahir.findOneById(bayiSaatLahir.id) != null

        return if (dataFound) {
            colBayiSaatLahir.updateOneById(bayiSaatLahir.id, bayiSaatLahir).wasAcknowledged()
        } else {
            bayiSaatLahir.id = ObjectId().toString()
            colBayiSaatLahir.insertOne(bayiSaatLahir).wasAcknowledged()
        }
    }

    override suspend fun deleteBayiSaatLahir(reqId: String): Boolean {
        val dataDelete = colBayiSaatLahir.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colBayiSaatLahir.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}