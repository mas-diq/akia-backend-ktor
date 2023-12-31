package com.masdiq.repository.pelayananDokter.trimester3

import com.masdiq.model.pelayananDokter.trimester3.PemeriksaanLaboratorium2
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPemeriksaanLaboratorium2 = DATABASE.getCollection<PemeriksaanLaboratorium2>()

class PemeriksaanLaboratorium2Implement : PemeriksaanLaboratorium2Repository {
    override suspend fun getAllPemeriksaanLaboratorium2(): List<PemeriksaanLaboratorium2> {
        return colPemeriksaanLaboratorium2.find().toList()
    }

    override suspend fun getPemeriksaanLaboratorium2(reqId: String): PemeriksaanLaboratorium2? {
        return colPemeriksaanLaboratorium2.findOneById(reqId)
    }

    override suspend fun createOrUpdatePemeriksaanLaboratorium2(pemeriksaanLaboratorium2: PemeriksaanLaboratorium2): Boolean {
        val dataFound = colPemeriksaanLaboratorium2.findOneById(pemeriksaanLaboratorium2.id) != null

        return if (dataFound) {
            colPemeriksaanLaboratorium2.updateOneById(pemeriksaanLaboratorium2.id, pemeriksaanLaboratorium2)
                .wasAcknowledged()
        } else {
            pemeriksaanLaboratorium2.id = ObjectId().toString()
            colPemeriksaanLaboratorium2.insertOne(pemeriksaanLaboratorium2).wasAcknowledged()
        }
    }

    override suspend fun deletePemeriksaanLaboratorium2(reqId: String): Boolean {
        val dataDelete = colPemeriksaanLaboratorium2.findOne(PemeriksaanLaboratorium2::id eq reqId)
        dataDelete?.let { data ->
            return colPemeriksaanLaboratorium2.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchPemeriksaanLaboratorium2(reqId: String): List<PemeriksaanLaboratorium2> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colPemeriksaanLaboratorium2.find(PemeriksaanLaboratorium2::userId eq reqId).toList()
        }
    }
}