package com.masdiq.repository

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val client = KMongo.createClient().coroutine
val DATABASE = client.getDatabase("Akia")

