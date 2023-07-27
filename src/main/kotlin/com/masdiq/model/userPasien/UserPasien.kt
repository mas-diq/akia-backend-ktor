package com.masdiq.model.userPasien

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class UserPasien(
    @BsonId
    var id: String = ObjectId().toString(),
    var userId: String? = "iu0001",
    val name: String? = "Kosong",
    val emailAddress: String? = "Kosong",
    val profilePhoto: String? = "Kosong",
    val userType: String? = "Kosong",
)