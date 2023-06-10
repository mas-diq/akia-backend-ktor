package com.masdiq.model

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val client = KMongo.createClient().coroutine
val DATABASE = client.getDatabase("Akia")
val BASE_URL = "/akia"
