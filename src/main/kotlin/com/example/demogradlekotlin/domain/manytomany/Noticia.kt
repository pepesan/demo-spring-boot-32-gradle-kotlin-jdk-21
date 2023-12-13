package com.example.demogradlekotlin.domain.manytomany

import jakarta.persistence.*
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Data
@NoArgsConstructor
class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    var titulo: String? = null


    // Otros campos de la noticia
    @ManyToMany
    @JoinTable(
        name = "noticia_etiqueta",
        joinColumns = [JoinColumn(name = "noticia_id")],
        inverseJoinColumns = [JoinColumn(name = "etiqueta_id")]
    )
    var etiquetas: MutableSet<Etiqueta> = mutableSetOf() // Getters y setters
}