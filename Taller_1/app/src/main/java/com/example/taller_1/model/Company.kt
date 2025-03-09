package com.example.taller_1.model

import kotlinx.serialization.Serializable

@Serializable
class Company (
    val department:  String,
    val name:       String,
    val title:      String
)