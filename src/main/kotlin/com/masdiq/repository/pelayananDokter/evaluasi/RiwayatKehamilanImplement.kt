package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.RiwayatKehamilan
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colRiwayatKehamilan = DATABASE.getCollection<RiwayatKehamilan>()

class RiwayatKehamilanImplement : RiwayatKehamilanRepository {
    override suspend fun getAllRiwayatKehamilan(): List<RiwayatKehamilan> {
        return colRiwayatKehamilan.find().toList()
    }

    override suspend fun getRiwayatKehamilan(reqId: String): RiwayatKehamilan? {
        return colRiwayatKehamilan.findOneById(reqId)
    }

    override suspend fun createOrUpdateRiwayatKehamilan(riwayatKehamilan: RiwayatKehamilan): Boolean {
        val dataFound = colRiwayatKehamilan.findOneById(riwayatKehamilan.id) != null

        return if (dataFound) {
            colRiwayatKehamilan.updateOneById(riwayatKehamilan.id, riwayatKehamilan).wasAcknowledged()
        } else {
            riwayatKehamilan.id = ObjectId().toString()
            colRiwayatKehamilan.insertOne(riwayatKehamilan).wasAcknowledged()
        }
    }

    override suspend fun deleteRiwayatKehamilan(reqId: String): Boolean {
        val dataDelete = colRiwayatKehamilan.findOne(RiwayatKehamilan::id eq reqId)
        dataDelete?.let { data ->
            return colRiwayatKehamilan.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }
}