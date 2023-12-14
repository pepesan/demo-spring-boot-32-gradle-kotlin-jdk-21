package com.example.demogradlekotlin.repositories

import com.example.demogradlekotlin.domain.Alumno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AlumnoRepository: JpaRepository<Alumno, Long> {
    // metodo Preestablecidos
    fun findByNombre(name: String?): List<Alumno?>?
    fun findByEdad(edad: Int?): List<Alumno?>?

    // Métodos mediante Query (hql)
    @Query("SELECT a FROM Alumno a WHERE a.nombre = :name")
    fun findAlumnosByName(name: String?): List<Alumno?>?

    // Uso de Named Query
    fun searchByNamedQueryName(@Param("name") name: String?): List<Alumno?>?
}