package com.example.simpleuserprofilefetcher.Data

data class User(
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val address: Address
)

data class Address(
    val street: String,
    val city: String
)