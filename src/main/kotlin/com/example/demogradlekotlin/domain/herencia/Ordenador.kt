package com.example.demogradlekotlin.domain.herencia

import jakarta.persistence.*
import lombok.Data
import lombok.NoArgsConstructor


@Data
@Entity
@NoArgsConstructor
/*
    Tenemos tre estrategias:
    - Table per class: cada entidad tiene su propia tabla
    con los campos comunes y sus específicos
    - Joined Table: Hay una tabla por cada entidad pero
    la tabla madre tiene los campos comunes de la
    entidad común y las tablas hijas los específicos de las
    entidades que heredan, se usa una FK para enlazar con la
    tabla madre y sus datos relacionados
    - Single Table: todas las Entidades en una misma tabla
    se usa un discriminador para distinguir entre registros
    de cada Entidad

 */
// Joined Table
@Inheritance(strategy = InheritanceType.JOINED)
open // Table per class
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// Single Table: para que todas las clases en una misma tabla
// con discriminador
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "tipo_ordenador")
class Ordenador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null

    private var marca: String? = null
    private var modelo: String? = null
}