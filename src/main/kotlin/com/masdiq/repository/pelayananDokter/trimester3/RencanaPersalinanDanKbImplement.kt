package com.masdiq.repository.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.RencanaPersalinanDanKb
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colRencanaPersalinanDanKb = DATABASE.getCollection<RencanaPersalinanDanKb>()

class RencanaPersalinanDanKbImplement : RencanaPersalinanDanKbRepository {
    override suspend fun getAllRencanaPersalinanDanKb(): List<RencanaPersalinanDanKb> {
        return colRencanaPersalinanDanKb.find().toList()
    }

    override suspend fun getRencanaPersalinanDanKb(reqId: String): RencanaPersalinanDanKb? {
        return colRencanaPersalinanDanKb.findOneById(reqId)
    }

    override suspend fun createOrUpdateRencanaPersalinanDanKb(rencanaPersalinanDanKb: RencanaPersalinanDanKb): Boolean {
        val dataFound = colRencanaPersalinanDanKb.findOneById(rencanaPersalinanDanKb.id) != null

        return if (dataFound) {
            colRencanaPersalinanDanKb.updateOneById(rencanaPersalinanDanKb.id, rencanaPersalinanDanKb).wasAcknowledged()
        } else {
            rencanaPersalinanDanKb.id = ObjectId().toString()
            colRencanaPersalinanDanKb.insertOne(rencanaPersalinanDanKb).wasAcknowledged()
        }
    }

    override suspend fun deleteRencanaPersalinanDanKb(reqId: String): Boolean {
        val dataDelete = colRencanaPersalinanDanKb.findOne(RencanaPersalinanDanKb::id eq reqId)
        dataDelete?.let { data ->
            return colRencanaPersalinanDanKb.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchRencanaPersalinanDanKb(reqId: String): List<RencanaPersalinanDanKb> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colRencanaPersalinanDanKb.find(RencanaPersalinanDanKb::userId eq reqId).toList()
        }
    }
}