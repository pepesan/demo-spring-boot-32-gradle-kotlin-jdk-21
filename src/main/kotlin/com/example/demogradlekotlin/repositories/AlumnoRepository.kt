package com.example.demogradlekotlin.repositories

import com.example.demogradlekotlin.domain.Alumno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlumnoRepository: JpaRepository<Alumno, Long> {
}