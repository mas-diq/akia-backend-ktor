package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.RiwayatKesehatan
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val colRiwayatKesehatan = DATABASE.getCollection<RiwayatKesehatan>()

class RiwayatKesehatanImplement : RiwayatKesehatanRepository {
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
        val dataDelete = colRiwayatKesehatan.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colRiwayatKesehatan.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}