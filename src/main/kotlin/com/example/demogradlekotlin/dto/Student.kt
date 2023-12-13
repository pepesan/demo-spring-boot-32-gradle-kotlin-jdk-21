package com.example.demogradlekotlin.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

class Student(
    val studentId: Long?,
    val lastName: String?,
    @Size(
        min = 3,
        max = 20,
        message = "el nombre debe tener mas de 3 letras y menos de 20."
    )
    val firstName: String)