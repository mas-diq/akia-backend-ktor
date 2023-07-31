package com.masdiq.repository.userPasien

import com.masdiq.model.userPasien.User

interface UserPasienRepository {
    suspend fun getAllUserPasien(): List<User>
    suspend fun getAllUserDokter(): List<User>
    suspend fun getUserPasien(reqId: String): List<User>
    suspend fun createOrUpdateUserPasien(user: User): Boolean
    suspend fun deleteUserPasien(reqId: String): Boolean
}