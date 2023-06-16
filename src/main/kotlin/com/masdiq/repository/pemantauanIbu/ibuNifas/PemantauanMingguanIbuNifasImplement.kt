package com.masdiq.repository.pemantauanIbu.ibuNifas

import com.masdiq.model.pemantauanIbu.ibuNifas.PemantauanMingguanIbuNifas
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPemantauanMingguanIbuNifas = DATABASE.getCollection<PemantauanMingguanIbuNifas>()

class PemantauanMingguanIbuNifasImplement : PemantauanMingguanIbuNifasRepository {
    override suspend fun getAllPemantauanMingguanIbuNifas(): List<PemantauanMingguanIbuNifas> {
        return colPemantauanMingguanIbuNifas.find().toList()
    }

    override suspend fun getPemantauanMingguanIbuNifas(reqId: String): PemantauanMingguanIbuNifas? {
        return colPemantauanMingguanIbuNifas.findOneById(reqId)
    }

    override suspend fun createOrUpdatePemantauanMingguanIbuNifas(pemantauanMingguanIbuNifas: PemantauanMingguanIbuNifas): Boolean {
        val dataFound = colPemantauanMingguanIbuNifas.findOneById(pemantauanMingguanIbuNifas.id) != null

        return if (dataFound) {
            colPemantauanMingguanIbuNifas.updateOneById(pemantauanMingguanIbuNifas.id, pemantauanMingguanIbuNifas)
                .wasAcknowledged()
        } else {
            pemantauanMingguanIbuNifas.id = ObjectId().toString()
            colPemantauanMingguanIbuNifas.insertOne(pemantauanMingguanIbuNifas).wasAcknowledged()
        }
    }

    override suspend fun deletePemantauanMingguanIbuNifas(reqId: String): Boolean {
        val dataDelete = colPemantauanMingguanIbuNifas.findOne(PemantauanMingguanIbuNifas::id eq reqId)
        dataDelete?.let { data ->
            return colPemantauanMingguanIbuNifas.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }
}