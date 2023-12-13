package com.example.demogradlekotlin.controllers

import com.example.demogradlekotlin.domain.Alumno
import com.example.demogradlekotlin.dto.AlumnoDTO
import com.example.demogradlekotlin.repositories.AlumnoRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/alumnos-repository", "/alumnos-repository"])
class AlumnoRepositoryController {
    var alumnoRepository: AlumnoRepository
    /*
    * Constructor de la clase AlumnoController
    * @param alumnoRepository: AlumnoRepository
    */
    @Autowired
    constructor(alumnoRepository: AlumnoRepository){
        this.alumnoRepository = alumnoRepository
    }
    /*

    * Método para obtener todos los alumnos
    * @return ResponseEntity<List<Alumno>>

     */
    @GetMapping("/")
    fun getAlumnos(): ResponseEntity<List<Alumno>>? {
        return ResponseEntity.ok(alumnoRepository.findAll())
    }
    /*

    * Método para crear un nuevo alumno
    * @param alumnoDTO: AlumnoDTO
    * @return ResponseEntity<Alumno>?
     */
    @PostMapping("/")
    fun createAlumno(
        @Valid @RequestBody alumnoDTO: AlumnoDTO): ResponseEntity<Alumno>? {
        val alumno = Alumno(alumnoDTO)
        return ResponseEntity.ok(alumnoRepository.save(alumno))
    }

    @GetMapping("/{id}")
    fun getAlumnoById(
        @Valid @PathVariable("id") id: Long): ResponseEntity<Alumno>? {
        val alummoOptional = alumnoRepository.findById(id)
        if (alummoOptional.isPresent) {
            return ResponseEntity.ok(alummoOptional.get())
        }else{
            return ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateAlumno(
        @Valid @PathVariable("id") id: Long,
        @Valid @RequestBody alumnoDTO: AlumnoDTO): ResponseEntity<Alumno>? {
        val alummoOptional = alumnoRepository.findById(id)
        if (alummoOptional.isPresent) {
            val alumno = alummoOptional.get()
            alumno.nombre = alumnoDTO.nombre
            alumno.apellidos = alumnoDTO.apellidos
            alumno.edad = alumnoDTO.edad
            return ResponseEntity.ok(alumnoRepository.save(alumno))
        }
         else{
            return ResponseEntity.notFound().build()
        }

    }

    @DeleteMapping("/{id}")
    fun deleteAlumno(@PathVariable("id") id: Long): ResponseEntity<Alumno>? {
        val alummoOptional = alumnoRepository.findById(id)
        if (alummoOptional.isPresent) {
            this.alumnoRepository.deleteById(id)
            return ResponseEntity.ok(alummoOptional.get())
        }else{
            return ResponseEntity.notFound().build()
        }
    }



}