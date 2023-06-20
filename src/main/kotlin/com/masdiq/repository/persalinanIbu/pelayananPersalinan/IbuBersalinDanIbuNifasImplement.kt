package com.masdiq.repository.persalinanIbu.pelayananPersalinan

import com.masdiq.model.persalinanIbu.pelayananPersalinan.IbuBersalinDanIbuNifas
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colIbuBersalinDanIbuNifas = DATABASE.getCollection<IbuBersalinDanIbuNifas>()

class IbuBersalinDanIbuNifasImplement : IbuBersalinDanIbuNifasRepository {
    override suspend fun getAllIbuBersalinDanIbuNifas(): List<IbuBersalinDanIbuNifas> {
        return colIbuBersalinDanIbuNifas.find().toList()
    }

    override suspend fun getIbuBersalinDanIbuNifas(reqId: String): IbuBersalinDanIbuNifas? {
        return colIbuBersalinDanIbuNifas.findOneById(reqId)
    }

    override suspend fun createOrUpdateIbuBersalinDanIbuNifas(ibuBersalinDanIbuNifas: IbuBersalinDanIbuNifas): Boolean {
        val dataFound = colIbuBersalinDanIbuNifas.findOneById(ibuBersalinDanIbuNifas.id) != null

        return if (dataFound) {
            colIbuBersalinDanIbuNifas.updateOneById(ibuBersalinDanIbuNifas.id, ibuBersalinDanIbuNifas).wasAcknowledged()
        } else {
            ibuBersalinDanIbuNifas.id = ObjectId().toString()
            colIbuBersalinDanIbuNifas.insertOne(ibuBersalinDanIbuNifas).wasAcknowledged()
        }
    }

    override suspend fun deleteIbuBersalinDanIbuNifas(reqId: String): Boolean {
        val dataDelete = colIbuBersalinDanIbuNifas.findOne(IbuBersalinDanIbuNifas::id eq reqId)
        dataDelete?.let { data ->
            return colIbuBersalinDanIbuNifas.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchIbuBersalinDanIbuNifas(reqId: String): List<IbuBersalinDanIbuNifas> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colIbuBersalinDanIbuNifas.find(IbuBersalinDanIbuNifas::userId eq reqId).toList()
        }
    }
}