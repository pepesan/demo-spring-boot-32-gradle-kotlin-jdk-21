package com.example.demogradlekotlin.domain.manytoone

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Book {
    @Id
    @GeneratedValue
    private val id: Long? = null

    var title: String? = null
}