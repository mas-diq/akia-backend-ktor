package com.masdiq.repository.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.RencanaPersalinanDanKb
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val colRencanaPersalinanDanKb = DATABASE.getCollection<RencanaPersalinanDanKb>()

class RencanaPersalinanDanKbImplement : RencanaPersalinanDanKbRepository {
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
        val dataDelete = colRencanaPersalinanDanKb.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colRencanaPersalinanDanKb.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}