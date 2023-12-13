package com.example.demogradlekotlin.domain.herencia

import jakarta.persistence.Entity
import jakarta.persistence.PrimaryKeyJoinColumn
import lombok.Data
import lombok.EqualsAndHashCode


@EqualsAndHashCode(callSuper = true)
@Data
@Entity // estrategia con Joined table
@PrimaryKeyJoinColumn(name = "OrdId") // si usamos Single Table debemos activar el discrimimador
// @DiscriminatorValue("sobremesa")
class Sobremesa : Ordenador() {
    var tipoTorre: String? = null
    var tieneMonitor = false
}