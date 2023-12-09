package com.example.demogradlekotlin.services

import com.example.demogradlekotlin.domain.Alumno
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*


@Service
interface AlumnoService {
    // listado
    fun findAll(): List<Alumno>
    // create/update
    fun save(alumno: Alumno): Alumno?

    // delete
    fun delete(id: Long): Optional<Alumno>
    // find by id
    fun findById(id: Long): Optional<Alumno>
}