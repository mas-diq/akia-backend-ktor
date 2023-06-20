package com.masdiq.repository.pemantauanIbu.ibuHamil

import com.masdiq.model.pemantauanIbu.ibuHamil.PemantauanMingguanIbuHamil
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPemantauanMingguanIbuHamil = DATABASE.getCollection<PemantauanMingguanIbuHamil>()

class PemantauanMingguanIbuHamilImplement : PemantauanMingguanIbuHamilRepository {
    override suspend fun getAllPemantauanMingguanIbuHamil(): List<PemantauanMingguanIbuHamil> {
        return colPemantauanMingguanIbuHamil.find().toList()
    }

    override suspend fun getPemantauanMingguanIbuHamil(reqId: String): PemantauanMingguanIbuHamil? {
        return colPemantauanMingguanIbuHamil.findOneById(reqId)
    }

    override suspend fun createOrUpdatePemantauanMingguanIbuHamil(pemantauanMingguanIbuHamil: PemantauanMingguanIbuHamil): Boolean {
        val dataFound = colPemantauanMingguanIbuHamil.findOneById(pemantauanMingguanIbuHamil.id) != null

        return if (dataFound) {
            colPemantauanMingguanIbuHamil.updateOneById(pemantauanMingguanIbuHamil.id, pemantauanMingguanIbuHamil)
                .wasAcknowledged()
        } else {
            pemantauanMingguanIbuHamil.id = ObjectId().toString()
            colPemantauanMingguanIbuHamil.insertOne(pemantauanMingguanIbuHamil).wasAcknowledged()
        }
    }

    override suspend fun deletePemantauanMingguanIbuHamil(reqId: String): Boolean {
        val dataDelete = colPemantauanMingguanIbuHamil.findOne(PemantauanMingguanIbuHamil::id eq reqId)
        dataDelete?.let { data ->
            return colPemantauanMingguanIbuHamil.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchPemantauanMingguanIbuHamil(reqId: String): List<PemantauanMingguanIbuHamil> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colPemantauanMingguanIbuHamil.find(PemantauanMingguanIbuHamil::userId eq reqId).toList()
        }
    }
}