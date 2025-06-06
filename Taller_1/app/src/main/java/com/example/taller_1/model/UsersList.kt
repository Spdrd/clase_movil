package com.example.taller_1.model

import kotlinx.serialization.Serializable

@Serializable
data class UsersList (
    val users: List<User> // Esta lista hace match con el JSON que devuelve la API
)