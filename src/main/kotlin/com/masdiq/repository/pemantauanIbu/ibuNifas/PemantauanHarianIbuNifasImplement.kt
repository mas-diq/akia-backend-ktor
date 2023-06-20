package com.masdiq.repository.pemantauanIbu.ibuNifas

import com.masdiq.model.pemantauanIbu.ibuNifas.PemantauanHarianIbuNifas
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPemantauanHarianIbuNifas = DATABASE.getCollection<PemantauanHarianIbuNifas>()

class PemantauanHarianIbuNifasImplement : PemantauanHarianIbuNifasRepository {
    override suspend fun getAllPemantauanHarianIbuNifas(): List<PemantauanHarianIbuNifas> {
        return colPemantauanHarianIbuNifas.find().toList()
    }

    override suspend fun getPemantauanHarianIbuNifas(reqId: String): PemantauanHarianIbuNifas? {
        return colPemantauanHarianIbuNifas.findOneById(reqId)
    }

    override suspend fun createOrUpdatePemantauanHarianIbuNifas(pemantauanHarianIbuNifas: PemantauanHarianIbuNifas): Boolean {
        val dataFound = colPemantauanHarianIbuNifas.findOneById(pemantauanHarianIbuNifas.id) != null

        return if (dataFound) {
            colPemantauanHarianIbuNifas.updateOneById(pemantauanHarianIbuNifas.id, pemantauanHarianIbuNifas)
                .wasAcknowledged()
        } else {
            pemantauanHarianIbuNifas.id = ObjectId().toString()
            colPemantauanHarianIbuNifas.insertOne(pemantauanHarianIbuNifas).wasAcknowledged()
        }
    }

    override suspend fun deletePemantauanHarianIbuNifas(reqId: String): Boolean {
        val dataDelete = colPemantauanHarianIbuNifas.findOne(PemantauanHarianIbuNifas::id eq reqId)
        dataDelete?.let { data ->
            return colPemantauanHarianIbuNifas.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchPemantauanHarianIbuNifas(reqId: String): List<PemantauanHarianIbuNifas> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colPemantauanHarianIbuNifas.find(PemantauanHarianIbuNifas::userId eq reqId).toList()
        }
    }
}