package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PemeriksaanKhusus
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPemeriksaanKhusus = DATABASE.getCollection<PemeriksaanKhusus>()

class PemeriksaanKhususImplement : PemeriksaanKhususRepository {
    override suspend fun getAllPemeriksaanKhusus(): List<PemeriksaanKhusus> {
        return colPemeriksaanKhusus.find().toList()
    }

    override suspend fun getPemeriksaanKhusus(reqId: String): PemeriksaanKhusus? {
        return colPemeriksaanKhusus.findOneById(reqId)
    }

    override suspend fun createOrUpdatePemeriksaanKhusus(pemeriksaanKhusus: PemeriksaanKhusus): Boolean {
        val dataFound = colPemeriksaanKhusus.findOneById(pemeriksaanKhusus.id) != null

        return if (dataFound) {
            colPemeriksaanKhusus.updateOneById(pemeriksaanKhusus.id, pemeriksaanKhusus).wasAcknowledged()
        } else {
            pemeriksaanKhusus.id = ObjectId().toString()
            colPemeriksaanKhusus.insertOne(pemeriksaanKhusus).wasAcknowledged()
        }
    }

    override suspend fun deletePemeriksaanKhusus(reqId: String): Boolean {
        val dataDelete = colPemeriksaanKhusus.findOne(PemeriksaanKhusus::id eq reqId)
        dataDelete?.let { data ->
            return colPemeriksaanKhusus.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchPemeriksaanKhusus(reqId: String): List<PemeriksaanKhusus> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colPemeriksaanKhusus.find(PemeriksaanKhusus::userId eq reqId).toList()
        }
    }
}