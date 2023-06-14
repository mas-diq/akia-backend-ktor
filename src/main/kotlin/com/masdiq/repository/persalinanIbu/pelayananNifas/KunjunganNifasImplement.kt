package com.masdiq.repository.persalinanIbu.pelayananNifas

import com.masdiq.model.persalinanIbu.pelayananNifas.KunjunganNifas
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val colKunjunganNifas = DATABASE.getCollection<KunjunganNifas>()

class KunjunganNifasImplement : KunjunganNifasRepository {
    override suspend fun getKunjunganNifas(reqId: String): KunjunganNifas? {
        return colKunjunganNifas.findOneById(reqId)
    }

    override suspend fun createOrUpdateKunjunganNifas(kunjunganNifas: KunjunganNifas): Boolean {
        val dataFound = colKunjunganNifas.findOneById(kunjunganNifas.id) != null

        return if (dataFound) {
            colKunjunganNifas.updateOneById(kunjunganNifas.id, kunjunganNifas).wasAcknowledged()
        } else {
            kunjunganNifas.id = ObjectId().toString()
            colKunjunganNifas.insertOne(kunjunganNifas).wasAcknowledged()
        }
    }

    override suspend fun deleteKunjunganNifas(reqId: String): Boolean {
        val dataDelete = colKunjunganNifas.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colKunjunganNifas.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}