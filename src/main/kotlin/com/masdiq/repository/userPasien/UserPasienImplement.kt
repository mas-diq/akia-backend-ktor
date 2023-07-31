package com.masdiq.repository.userPasien

import com.masdiq.model.userPasien.User
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colUserPasien = DATABASE.getCollection<User>()

class UserPasienImplement : UserPasienRepository {
    override suspend fun getAllUserPasien(): List<User> {
        return colUserPasien.find(User::userType eq "Pasien").toList()
    }

    override suspend fun getAllUserDokter(): List<User> {
        return colUserPasien.find(User::userType eq "Dokter").toList()
    }

    override suspend fun getUserPasien(reqId: String): List<User> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colUserPasien.find(User::userId eq reqId).toList()
        }
    }

    override suspend fun createOrUpdateUserPasien(user: User): Boolean {
        val dataFound = colUserPasien.findOneById(user.id) != null

        return if (dataFound) {
            colUserPasien.updateOneById(user.id, user).wasAcknowledged()
        } else {
            user.id = ObjectId().toString()
            colUserPasien.insertOne(user).wasAcknowledged()
        }
    }

    override suspend fun deleteUserPasien(reqId: String): Boolean {
        val dataDelete = colUserPasien.findOne(User::id eq reqId)
        dataDelete?.let { data ->
            return colUserPasien.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }
}