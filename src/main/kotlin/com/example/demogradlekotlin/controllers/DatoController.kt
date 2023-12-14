package com.example.demogradlekotlin.controllers

import com.example.demogradlekotlin.dto.Dato
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "dato", description = "the dato simple API")
class DatoController {
    @GetMapping(value = ["/dato-simple"])
    fun index(): Dato {
        return Dato(1L, "Hola")
    }

    @GetMapping(value = ["/dato-response"])
    fun indexResponse(): ResponseEntity<Dato> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        return ResponseEntity<Dato>(Dato(1L, "Hola"), headers, HttpStatus.OK)
    }

    @GetMapping("/dato-json")
    fun indexJson(): ResponseEntity<String> {
        val d: Dato = Dato(1L, "Hola")
        d.id=1L
        System.out.println(d.id)
        d.cadena="Hola"
        val salida = """
            {
                "id": ${d.id},
                "cadena": ${d.cadena}
            }
            
        """.trimIndent()

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        return ResponseEntity(salida, headers, HttpStatus.OK)
    }
}