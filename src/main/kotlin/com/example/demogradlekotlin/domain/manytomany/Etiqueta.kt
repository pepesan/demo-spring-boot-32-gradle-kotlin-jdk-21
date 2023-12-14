package com.example.demogradlekotlin.domain.manytomany

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Data
@NoArgsConstructor
class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    var nombre: String? = null // Otros campos de la etiqueta
    // No se agrega la relación inversa en este ejemplo, ya que es unidireccional
    // Getters y setters

}