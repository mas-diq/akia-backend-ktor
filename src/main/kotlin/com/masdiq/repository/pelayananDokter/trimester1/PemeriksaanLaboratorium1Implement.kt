package com.masdiq.repository.pelayananDokter.trimester1

import com.masdiq.model.pelayananDokter.trimester1.PemeriksaanLaboratorium1
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val colPemeriksaanLaboratorium1 = DATABASE.getCollection<PemeriksaanLaboratorium1>()

class PemeriksaanLaboratorium1Implement : PemeriksaanLaboratorium1Repository {
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
        val dataDelete = colPemeriksaanLaboratorium1.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colPemeriksaanLaboratorium1.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}