package com.example.demogradlekotlin.domain

import com.example.demogradlekotlin.dto.AlumnoDTO
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size

@Entity
data class Alumno (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Size(min = 3, max = 20, message = "el nombre debe tener mas de 3 letras y menos de 20.")
    var nombre: String,
    var apellidos: String,
    @Min(value = 18, message = "el usuario debe tener 18+")
    var edad: Int
) {
    constructor(alumnoDTO: AlumnoDTO) : this(
        id = 0,
        nombre = alumnoDTO.nombre,
        apellidos = alumnoDTO.apellidos,
        edad = alumnoDTO.edad
    )
}