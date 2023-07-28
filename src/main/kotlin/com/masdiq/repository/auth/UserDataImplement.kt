package com.masdiq.repository.auth

import com.masdiq.model.userPasien.User
import com.masdiq.repository.DATABASE
import org.litote.kmongo.eq
import org.litote.kmongo.setValue

private val colUser = DATABASE.getCollection<User>()

class UserDataImplement : UserDataInterface {
    override suspend fun getUserInfo(reqUserId: String): User? {
        return colUser.findOne(filter = User::userId eq reqUserId)
    }

    override suspend fun saveUserInfo(user: User): Boolean {
        val existingUser = colUser.findOne(filter = User::userId eq user.userId)
        return if (existingUser == null) {
            colUser.insertOne(document = user).wasAcknowledged()
        } else {
            true
        }
    }

    override suspend fun deleteUser(reqUserId: String): Boolean {
        return colUser.deleteOne(filter = User::userId eq reqUserId).wasAcknowledged()
    }

    override suspend fun updateUserInfo(userId: String, firstName: String, lastName: String): Boolean {
        return colUser.updateOne(
            filter = User::userId eq userId, update = setValue(
                property = User::name,
                value = "$firstName $lastName"
            )
        ).wasAcknowledged()
    }
}