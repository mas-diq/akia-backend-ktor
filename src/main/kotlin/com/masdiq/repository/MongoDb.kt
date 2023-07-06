package com.masdiq.repository

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val client = KMongo.createClient("mongodb+srv://masdiq:B76bnyQkRz2VJR0s@cluster0.qhwa22p.mongodb.net/?retryWrites=true&w=majority").coroutine
val DATABASE = client.getDatabase("akia_database")

