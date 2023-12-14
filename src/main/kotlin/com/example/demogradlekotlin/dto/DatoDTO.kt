package com.example.demogradlekotlin.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Data
@NoArgsConstructor
@AllArgsConstructor
class DatoDTO(cadena: String) {
    var cadena: @NotNull @NotBlank @Size(
        min = 4,
        max = 20,
        message = "Debe tener entre 1 y 100 chars"
    ) String = cadena
}