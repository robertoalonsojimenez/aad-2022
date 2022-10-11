package com.ralonsoj.aad_2022.ut01.ex05.domain

data class User(val id: Int, val name: String, val username: String, val email: String,
                val phone: String, val website: String,
                val adress: Adress, val geo: Geo, val company: Company)
data class Adress(val street: String, val suite: String, val city: String, val zipcode: String)
data class Geo(val lat: Double, val lng: Double)
data class Company(val name: String, val catchPhrase: String, val bs: String)