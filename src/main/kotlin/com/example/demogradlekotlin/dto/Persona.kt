package com.example.demogradlekotlin.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size


data class Persona
    (
    @Size(
        min = 3,
        max = 20,
        message = "el nombre debe tener mas de 3 letras y menos de 20."
    )
    private val nombre: String,
    private val apellidos: String,
    @Min(
        value = 18,
        message = "el usuario debe tener 18+"
    )
    private val edad: Int
)