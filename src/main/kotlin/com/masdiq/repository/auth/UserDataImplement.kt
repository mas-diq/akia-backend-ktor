package com.masdiq.repository.auth

import com.masdiq.model.userPasien.UserPasien
import com.masdiq.repository.DATABASE
import org.litote.kmongo.eq
import org.litote.kmongo.setValue

private val colUserPasien = DATABASE.getCollection<UserPasien>()

class UserDataImplement : UserDataInterface {
    override suspend fun getUserInfo(reqUserId: String): UserPasien? {
        return colUserPasien.findOne(filter = UserPasien::userId eq reqUserId)
    }

    override suspend fun saveUserInfo(userPasien: UserPasien): Boolean {
        val existingUserPasien = colUserPasien.findOne(filter = UserPasien::userId eq userPasien.userId)
        return if (existingUserPasien == null) {
            colUserPasien.insertOne(document = userPasien).wasAcknowledged()
        } else {
            true
        }
    }

    override suspend fun deleteUser(reqUserId: String): Boolean {
        return colUserPasien.deleteOne(filter = UserPasien::userId eq reqUserId).wasAcknowledged()
    }

    override suspend fun updateUserInfo(userId: String, firstName: String, lastName: String): Boolean {
        return colUserPasien.updateOne(
            filter = UserPasien::userId eq userId, update = setValue(
                property = UserPasien::name,
                value = "$firstName $lastName"
            )
        ).wasAcknowledged()
    }
}