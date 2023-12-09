package com.example.demogradlekotlin.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size
import lombok.Data

@Data
data class AlumnoDTO  (
    @Size(min = 3, max = 20, message = "el nombre debe tener mas de 3 letras y menos de 20.")
    var nombre: String = "",
    var apellidos: String = "",
    @Min(value = 18, message = "el usuario debe tener 18+")
    var edad: Int = 18
){

}