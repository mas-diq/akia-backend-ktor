package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.KondisiKesehatan
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colKondisiKesehatan = DATABASE.getCollection<KondisiKesehatan>()

class KondisiKesehatanImplement : KondisiKesehatanRepository {
    override suspend fun getAllKondisiKesehatan(): List<KondisiKesehatan> {
        return colKondisiKesehatan.find().toList()
    }

    override suspend fun getKondisiKesehatan(reqId: String): KondisiKesehatan? {
        return colKondisiKesehatan.findOneById(reqId)
    }

    override suspend fun createOrUpdateKondisiKesehatan(kondisiKesehatan: KondisiKesehatan): Boolean {
        val dataFound = colKondisiKesehatan.findOneById(kondisiKesehatan.id) != null

        return if (dataFound) {
            colKondisiKesehatan.updateOneById(kondisiKesehatan.id, kondisiKesehatan).wasAcknowledged()
        } else {
            kondisiKesehatan.id = ObjectId().toString()
            colKondisiKesehatan.insertOne(kondisiKesehatan).wasAcknowledged()
        }
    }

    override suspend fun deleteKondisiKesehatan(reqId: String): Boolean {
        val dataDelete = colKondisiKesehatan.findOne(KondisiKesehatan::id eq reqId)
        dataDelete?.let { tablet ->
            return colKondisiKesehatan.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}
