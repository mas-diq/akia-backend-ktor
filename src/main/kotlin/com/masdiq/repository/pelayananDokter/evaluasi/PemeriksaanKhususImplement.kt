package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PemeriksaanKhusus
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val colPemeriksaanKhusus = DATABASE.getCollection<PemeriksaanKhusus>()

class PemeriksaanKhususImplement : PemeriksaanKhususRepository {
    override suspend fun getPemeriksaanKhususRepository(reqId: String): PemeriksaanKhusus? {
        return colPemeriksaanKhusus.findOneById(reqId)
    }

    override suspend fun createOrUpdatePemeriksaanKhususRepository(pemeriksaanKhusus: PemeriksaanKhusus): Boolean {
        val dataFound = colPemeriksaanKhusus.findOneById(pemeriksaanKhusus.id) != null

        return if (dataFound) {
            colPemeriksaanKhusus.updateOneById(pemeriksaanKhusus.id, pemeriksaanKhusus).wasAcknowledged()
        } else {
            pemeriksaanKhusus.id = ObjectId().toString()
            colPemeriksaanKhusus.insertOne(pemeriksaanKhusus).wasAcknowledged()
        }
    }

    override suspend fun deletePemeriksaanKhususRepository(reqId: String): Boolean {
        val dataDelete = colPemeriksaanKhusus.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colPemeriksaanKhusus.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}