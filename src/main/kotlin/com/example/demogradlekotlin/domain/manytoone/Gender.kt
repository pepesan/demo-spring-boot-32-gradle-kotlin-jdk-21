package com.example.demogradlekotlin.domain.manytoone

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    var name: String? = null

    @OneToMany(
        cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE
        ],
        fetch = FetchType.EAGER
    )
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    var books: MutableSet<Book> = mutableSetOf()

}