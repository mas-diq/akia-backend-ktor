package com.masdiq.repository.auth

import com.masdiq.model.auth.User

interface UserDataInterface {
    suspend fun getUserInfo(userId: String): User?
    suspend fun saveUserInfo(user: User): Boolean
    suspend fun deleteUser(userId: String): Boolean
    suspend fun updateUserInfo(
        userId: String,
        firstName: String,
        lastName: String,
    ): Boolean
}