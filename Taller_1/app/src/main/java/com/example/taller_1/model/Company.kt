package com.example.taller_1.model

import kotlinx.serialization.Serializable

@Serializable
class Company (
    val deparment:  String,
    val name:       String,
    val title:      String
)