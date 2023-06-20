package com.masdiq.repository.pelayananDokter.trimester1

import com.masdiq.model.pelayananDokter.trimester1.PemeriksaanLaboratorium1
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPemeriksaanLaboratorium1 = DATABASE.getCollection<PemeriksaanLaboratorium1>()

class PemeriksaanLaboratorium1Implement : PemeriksaanLaboratorium1Repository {
    override suspend fun getAllPemeriksaanLaboratorium1(): List<PemeriksaanLaboratorium1> {
        return colPemeriksaanLaboratorium1.find().toList()
    }

    override suspend fun getPemeriksaanLaboratorium1(reqId: String): PemeriksaanLaboratorium1? {
        return colPemeriksaanLaboratorium1.findOneById(reqId)
    }

    override suspend fun createOrUpdatePemeriksaanLaboratorium1(pemeriksaanLaboratorium1: PemeriksaanLaboratorium1): Boolean {
        val dataFound = colPemeriksaanLaboratorium1.findOneById(pemeriksaanLaboratorium1.id) != null

        return if (dataFound) {
            colPemeriksaanLaboratorium1.updateOneById(pemeriksaanLaboratorium1.id, pemeriksaanLaboratorium1)
                .wasAcknowledged()
        } else {
            pemeriksaanLaboratorium1.id = ObjectId().toString()
            colPemeriksaanLaboratorium1.insertOne(pemeriksaanLaboratorium1).wasAcknowledged()
        }
    }

    override suspend fun deletePemeriksaanLaboratorium1(reqId: String): Boolean {
        val dataDelete = colPemeriksaanLaboratorium1.findOne(PemeriksaanLaboratorium1::id eq reqId)
        dataDelete?.let { data ->
            return colPemeriksaanLaboratorium1.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchPemeriksaanLaboratorium1(reqId: String): List<PemeriksaanLaboratorium1> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colPemeriksaanLaboratorium1.find(PemeriksaanLaboratorium1::userId eq reqId).toList()
        }
    }
}