package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.RiwayatKesehatan
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colRiwayatKesehatan = DATABASE.getCollection<RiwayatKesehatan>()

class RiwayatKesehatanImplement : RiwayatKesehatanRepository {
    override suspend fun getAllRiwayatKesehatan(): List<RiwayatKesehatan> {
        return colRiwayatKesehatan.find().toList()
    }

    override suspend fun getRiwayatKesehatan(reqId: String): RiwayatKesehatan? {
        return colRiwayatKesehatan.findOneById(reqId)
    }

    override suspend fun createOrUpdateRiwayatKesehatan(riwayatKesehatan: RiwayatKesehatan): Boolean {
        val dataFound = colRiwayatKesehatan.findOneById(riwayatKesehatan.id) != null

        return if (dataFound) {
            colRiwayatKesehatan.updateOneById(riwayatKesehatan.id, riwayatKesehatan).wasAcknowledged()
        } else {
            riwayatKesehatan.id = ObjectId().toString()
            colRiwayatKesehatan.insertOne(riwayatKesehatan).wasAcknowledged()
        }
    }

    override suspend fun deleteRiwayatKesehatan(reqId: String): Boolean {
        val dataDelete = colRiwayatKesehatan.findOne(RiwayatKesehatan::id eq reqId)
        dataDelete?.let { data ->
            return colRiwayatKesehatan.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchRiwayatKesehatan(reqId: String): List<RiwayatKesehatan> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colRiwayatKesehatan.find(RiwayatKesehatan::userId eq reqId).toList()
        }
    }
}