package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.KondisiKesehatan
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
        dataDelete?.let { data ->
            return colKondisiKesehatan.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchKondisiKesehatan(reqId: String): List<KondisiKesehatan> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colKondisiKesehatan.find(KondisiKesehatan::userId eq reqId).toList()
        }
    }
}
