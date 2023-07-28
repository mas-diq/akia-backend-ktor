package com.masdiq.repository.auth

import com.masdiq.model.userPasien.User

interface UserDataInterface {
    suspend fun getUserInfo(reqUserId: String): User?
    suspend fun saveUserInfo(user: User): Boolean
    suspend fun deleteUser(reqUserId: String): Boolean
    suspend fun updateUserInfo(
        userId: String,
        firstName: String,
        lastName: String,
    ): Boolean
}