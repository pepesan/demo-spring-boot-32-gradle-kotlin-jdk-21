package com.example.demogradlekotlin.services

import com.example.demogradlekotlin.domain.Alumno
import com.example.demogradlekotlin.repositories.AlumnoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AlumnoServiceImpl: AlumnoService {
    var alumnoRepository: AlumnoRepository

    @Autowired
    constructor(alumnoRepository: AlumnoRepository){
        this.alumnoRepository = alumnoRepository
    }

    override fun findAll(): List<Alumno> {
        return this.alumnoRepository.findAll()
    }

    override fun save(alumno: Alumno): Alumno {
        return this.alumnoRepository.save(alumno)
    }

    override fun deleteById(id: Long): Optional<Alumno> {
        val alumno = this.alumnoRepository.findById(id)
        this.alumnoRepository.deleteById(id)
        return alumno
    }

    override fun findById(id: Long): Optional<Alumno> {
        return this.alumnoRepository.findById(id)
    }
}