package com.masdiq.repository.persalinanIbu.pelayananNifas

import com.masdiq.model.persalinanIbu.pelayananNifas.KesimpulanAkhirNifas
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colKesimpulanAkhirNifas = DATABASE.getCollection<KesimpulanAkhirNifas>()

class KesimpulanAkhirNifasImplement : KesimpulanAkhirNifasRepository {
    override suspend fun getAllKesimpulanAkhirNifas(): List<KesimpulanAkhirNifas> {
        return colKesimpulanAkhirNifas.find().toList()
    }

    override suspend fun getKesimpulanAkhirNifas(reqId: String): KesimpulanAkhirNifas? {
        return colKesimpulanAkhirNifas.findOneById(reqId)
    }

    override suspend fun createOrUpdateKesimpulanAkhirNifas(kesimpulanAkhirNifas: KesimpulanAkhirNifas): Boolean {
        val dataFound = colKesimpulanAkhirNifas.findOneById(kesimpulanAkhirNifas.id) != null

        return if (dataFound) {
            colKesimpulanAkhirNifas.updateOneById(kesimpulanAkhirNifas.id, kesimpulanAkhirNifas).wasAcknowledged()
        } else {
            kesimpulanAkhirNifas.id = ObjectId().toString()
            colKesimpulanAkhirNifas.insertOne(kesimpulanAkhirNifas).wasAcknowledged()
        }
    }

    override suspend fun deleteKesimpulanAkhirNifas(reqId: String): Boolean {
        val dataDelete = colKesimpulanAkhirNifas.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { data ->
            return colKesimpulanAkhirNifas.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }
}