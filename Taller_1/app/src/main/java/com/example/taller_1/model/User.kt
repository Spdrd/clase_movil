package com.example.taller_1.model

import kotlinx.serialization.Serializable


@Serializable
class User (
    val id:         Int,
    val name:       String,
    val lastName:   String,
    val company:    Company,
    val image:      String,
    val maidenName: String,
    val age:        Int,
    val gender:     String,
    val email:      String,
    val phone:      String
)