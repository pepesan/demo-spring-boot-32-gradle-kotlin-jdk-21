package com.example.demogradlekotlin.domain.manytomany

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long = 0
    var name: String? = null

    @ManyToMany(
        cascade = [CascadeType.PERSIST, CascadeType.MERGE
        ], fetch = FetchType.EAGER, mappedBy = "roles"
    )
    val users: MutableSet<User> = mutableSetOf()
}