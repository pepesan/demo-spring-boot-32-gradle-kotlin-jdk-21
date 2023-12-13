package com.example.demogradlekotlin.repositories.manytoone

import com.example.demogradlekotlin.domain.manytoone.Gender
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenderRepository : JpaRepository<Gender?, Long?>