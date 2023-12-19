package com.example.demogradlekotlin.controllers

import com.example.demogradlekotlin.domain.Alumno
import com.example.demogradlekotlin.dto.AlumnoDTO
import com.example.demogradlekotlin.services.AlumnoService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api/v1/alumnos", "/alumnos"])
class AlumnoController
    /*
    * Constructor de la clase AlumnoController
    * @param alumnoService: AlumnoService
    */
    @Autowired constructor(var alumnoService: AlumnoService) {
    /*

    * Método para obtener todos los alumnos
    * @return ResponseEntity<List<Alumno>>

     */
    @GetMapping("/")
    fun getAlumnos(): ResponseEntity<List<Alumno>>? {
        return ResponseEntity.ok(alumnoService.findAll())
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
        return ResponseEntity.ok(alumnoService.save(alumno))
    }

    /**
     * Método para obtener un alumno por su ID
     * @param id: Long
     * @return ResponseEntity<Alumno>
     */
    @GetMapping("/{id}")
    fun getAlumnoById(
        @Valid @PathVariable("id") id: Long): ResponseEntity<Alumno> {
        val alummo = alumnoService.findById(id)
            .orElseThrow<ResourceNotFoundException> {
                ResourceNotFoundException(
                    "Not found with id = $id"
                )
            }

        return ResponseEntity.ok(alummo)
    }

    /**
     * Método para actualizar un alumno
     * @param id: Long
     * @param alumnoDTO: AlumnoDTO
     * @return ResponseEntity<Alumno>
     */
    @PutMapping("/{id}")
    fun updateAlumno(
        @Valid @PathVariable("id") id: Long,
        @Valid @RequestBody alumnoDTO: AlumnoDTO): ResponseEntity<Alumno> {
        val alummo = alumnoService.findById(id)
            .orElseThrow<ResourceNotFoundException> {
                ResourceNotFoundException(
                    "Not found with id = $id"
                )
            }
        alummo.nombre = alumnoDTO.nombre
        alummo.apellidos = alumnoDTO.apellidos
        alummo.edad = alumnoDTO.edad
        return ResponseEntity.ok(alumnoService.save(alummo))
    }

    /**
     * Método para eliminar un alumno
     * @param id: Long
     * @return ResponseEntity<Alumno>
     */
    @DeleteMapping("/{id}")
    fun deleteAlumno(@PathVariable("id") id: Long): ResponseEntity<Alumno> {
        val alummo= alumnoService.findById(id)
            .orElseThrow<ResourceNotFoundException> {
                ResourceNotFoundException(
                    "Not found with id = $id"
                )
            }
        this.alumnoService.deleteById(id)
        return ResponseEntity.ok(alummo)
    }



}