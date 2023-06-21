package com.masdiq.repository.auth

import com.masdiq.model.auth.User
import com.masdiq.repository.DATABASE
import org.litote.kmongo.eq
import org.litote.kmongo.setValue

private val colUser = DATABASE.getCollection<User>()

class UserDataImplement : UserDataInterface {
    override suspend fun getUserInfo(userId: String): User? {
        return colUser.findOne(filter = User::id eq userId)
    }

    override suspend fun saveUserInfo(user: User): Boolean {
        val existingUser = colUser.findOne(filter = User::id eq user.id)
        return if (existingUser == null) {
            colUser.insertOne(document = user).wasAcknowledged()
        } else {
            true
        }
    }

    override suspend fun deleteUser(userId: String): Boolean {
        return colUser.deleteOne(filter = User::id eq userId).wasAcknowledged()
    }

    override suspend fun updateUserInfo(userId: String, firstName: String, lastName: String): Boolean {
        return colUser.updateOne(
            filter = User::id eq userId, update = setValue(
                property = User::name,
                value = "$firstName $lastName"
            )
        ).wasAcknowledged()
    }
}