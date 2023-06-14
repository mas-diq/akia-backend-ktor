package com.masdiq.repository.pelayananDokter.trimester2

import com.masdiq.model.pelayananDokter.trimester2.SkriningPreeklampsia
import com.masdiq.model.persalinanIbu.pelayananPersalinan.BayiSaatLahir
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

val colSkriningPreeklampsia = DATABASE.getCollection<SkriningPreeklampsia>()

class SkriningPreeklampsiaImplement : SkriningPreeklampsiaRepository {
    override suspend fun getSkriningPreeklampsia(reqId: String): SkriningPreeklampsia? {
        return colSkriningPreeklampsia.findOneById(reqId)
    }

    override suspend fun createOrUpdateSkriningPreeklampsia(skriningPreeklampsia: SkriningPreeklampsia): Boolean {
        val dataFound = colSkriningPreeklampsia.findOneById(skriningPreeklampsia.id) != null

        return if (dataFound) {
            colSkriningPreeklampsia.updateOneById(skriningPreeklampsia.id, skriningPreeklampsia).wasAcknowledged()
        } else {
            skriningPreeklampsia.id = ObjectId().toString()
            colSkriningPreeklampsia.insertOne(skriningPreeklampsia).wasAcknowledged()
        }
    }

    override suspend fun deleteSkriningPreeklampsia(reqId: String): Boolean {
        val dataDelete = colSkriningPreeklampsia.findOne(BayiSaatLahir::id eq reqId)
        dataDelete?.let { tablet ->
            return colSkriningPreeklampsia.deleteOneById(tablet.id).wasAcknowledged()
        } ?: return false
    }
}