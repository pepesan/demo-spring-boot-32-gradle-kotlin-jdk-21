package com.example.demogradlekotlin.domain.onetoone

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Entity(name = "PhoneDetails")
@NoArgsConstructor
@AllArgsConstructor
class PhoneDetails {
    @Id
    @GeneratedValue
    private val id: Long? = null
    var provider: String? = null
    var technology: String? = null
}