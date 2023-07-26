package com.masdiq.repository

import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

const val userPasien = "akia-pasien"
const val userDokter = "akia-dokter"
const val passPasien = "UOWsc2MUOXx7bVhL"
const val passDokter = "mQ5uS8pY3HAgtIev"

var key = "mongodb+srv://${userDokter}:${passDokter}@cluster0.qhwa22p.mongodb.net/?retryWrites=true&w=majority"

val client = KMongo.createClient(key).coroutine
val DATABASE = client.getDatabase("akia_database")