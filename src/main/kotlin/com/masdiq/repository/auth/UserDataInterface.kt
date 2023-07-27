package com.masdiq.repository.auth

import com.masdiq.model.userPasien.UserPasien

interface UserDataInterface {
    suspend fun getUserInfo(reqUserId: String): UserPasien?
    suspend fun saveUserInfo(userPasien: UserPasien): Boolean
    suspend fun deleteUser(reqUserId: String): Boolean
    suspend fun updateUserInfo(
        userId: String,
        firstName: String,
        lastName: String,
    ): Boolean
}