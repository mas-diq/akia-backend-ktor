package com.masdiq.repository.userPasien

import com.masdiq.model.userPasien.UserPasien

interface UserPasienRepository {
    suspend fun getAllUserPasien(): List<UserPasien>

    suspend fun getUserPasien(reqId: String): UserPasien?

    suspend fun createOrUpdateUserPasien(userPasien: UserPasien): Boolean

    suspend fun deleteUserPasien(reqId: String): Boolean
    suspend fun searchUserPasien(reqId: String): List<UserPasien>
}