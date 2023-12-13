package com.example.demogradlekotlin.domain.herencia

import jakarta.persistence.Entity
import jakarta.persistence.PrimaryKeyJoinColumn
import lombok.Data
import lombok.EqualsAndHashCode

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@PrimaryKeyJoinColumn(name = "OrdId") // estrategia con Joined table
// si usamos Joined debemos activar el discrimimador
//@DiscriminatorValue("portatil")
class Portatil : Ordenador() {
    var peso = 0.0
    var duracionBateria = 0
}