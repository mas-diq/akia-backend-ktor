package com.masdiq.repository.pelayananDokter

import com.masdiq.model.pelayananDokter.PemeriksaanFisik
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPemeriksaanFisik = DATABASE.getCollection<PemeriksaanFisik>()

class PemeriksaanFisikImplement : PemeriksaanFisikRepository {
    override suspend fun getAllPemeriksaanFisik(): List<PemeriksaanFisik> {
        return colPemeriksaanFisik.find().toList()
    }

    override suspend fun getPemeriksaanFisik(reqId: String): PemeriksaanFisik? {
        return colPemeriksaanFisik.findOneById(reqId)
    }

    override suspend fun createOrUpdatePemeriksaanFisik(riwayatKesehatan: PemeriksaanFisik): Boolean {
        val dataFound = colPemeriksaanFisik.findOneById(riwayatKesehatan.id) != null

        return if (dataFound) {
            colPemeriksaanFisik.updateOneById(riwayatKesehatan.id, riwayatKesehatan).wasAcknowledged()
        } else {
            riwayatKesehatan.id = ObjectId().toString()
            colPemeriksaanFisik.insertOne(riwayatKesehatan).wasAcknowledged()
        }
    }

    override suspend fun deletePemeriksaanFisik(reqId: String): Boolean {
        val dataDelete = colPemeriksaanFisik.findOne(PemeriksaanFisik::id eq reqId)
        dataDelete?.let { data ->
            return colPemeriksaanFisik.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchPemeriksaanFisik(reqId: String): List<PemeriksaanFisik> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colPemeriksaanFisik.find(PemeriksaanFisik::userId eq reqId).toList()
        }
    }
}