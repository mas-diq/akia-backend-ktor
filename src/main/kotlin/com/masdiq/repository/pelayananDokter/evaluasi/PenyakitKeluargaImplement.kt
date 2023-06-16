package com.masdiq.repository.pelayananDokter.evaluasi

import com.masdiq.model.pelayananDokter.evaluasi.PenyakitKeluarga
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colPenyakitKeluarga = DATABASE.getCollection<PenyakitKeluarga>()

class PenyakitKeluargaImplement : PenyakitKeluargaRepository {
    override suspend fun getAllPenyakitKeluarga(): List<PenyakitKeluarga> {
        return colPenyakitKeluarga.find().toList()
    }

    override suspend fun getPenyakitKeluarga(reqId: String): PenyakitKeluarga? {
        return colPenyakitKeluarga.findOneById(reqId)
    }

    override suspend fun createOrUpdatePenyakitKeluarga(penyakitKeluarga: PenyakitKeluarga): Boolean {
        val dataFound = colPenyakitKeluarga.findOneById(penyakitKeluarga.id) != null

        return if (dataFound) {
            colPenyakitKeluarga.updateOneById(penyakitKeluarga.id, penyakitKeluarga).wasAcknowledged()
        } else {
            penyakitKeluarga.id = ObjectId().toString()
            colPenyakitKeluarga.insertOne(penyakitKeluarga).wasAcknowledged()
        }
    }

    override suspend fun deleteTabletPenyakitKeluarga(reqId: String): Boolean {
        val dataDelete = colPenyakitKeluarga.findOne(PenyakitKeluarga::id eq reqId)
        dataDelete?.let { data ->
            return colPenyakitKeluarga.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }
}
