package com.masdiq.repository.userPasien

import com.masdiq.model.userPasien.UserPasien
import com.masdiq.repository.DATABASE
import org.bson.types.ObjectId
import org.litote.kmongo.eq

private val colUserPasienPasien = DATABASE.getCollection<UserPasien>()

class UserPasienImplement : UserPasienRepository {
    override suspend fun getAllUserPasien(): List<UserPasien> {
        return colUserPasienPasien.find().toList()
    }

    override suspend fun getUserPasien(reqId: String): UserPasien? {
        return colUserPasienPasien.findOneById(reqId)
    }

    override suspend fun createOrUpdateUserPasien(userPasien: UserPasien): Boolean {
        val dataFound = colUserPasienPasien.findOneById(userPasien.id) != null

        return if (dataFound) {
            colUserPasienPasien.updateOneById(userPasien.id, userPasien).wasAcknowledged()
        } else {
            userPasien.id = ObjectId().toString()
            colUserPasienPasien.insertOne(userPasien).wasAcknowledged()
        }
    }

    override suspend fun deleteUserPasien(reqId: String): Boolean {
        val dataDelete = colUserPasienPasien.findOne(UserPasien::id eq reqId)
        dataDelete?.let { data ->
            return colUserPasienPasien.deleteOneById(data.id).wasAcknowledged()
        } ?: return false
    }

    override suspend fun searchUserPasien(reqId: String): List<UserPasien> {
        return if (reqId.isEmpty()) {
            emptyList()
        } else {
            return colUserPasienPasien.find(UserPasien::userId eq reqId).toList()
        }
    }
}