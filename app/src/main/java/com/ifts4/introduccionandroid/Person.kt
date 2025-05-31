package com.ifts4.introduccionandroid

data class Person(
    val name: String,
    val lastName: String,
    val password: String,
    val city: String
) : java.io.Serializable
