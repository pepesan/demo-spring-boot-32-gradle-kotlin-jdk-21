package com.example.demogradlekotlin.controllers

import com.example.demogradlekotlin.dto.Dato
import com.example.demogradlekotlin.dto.DatoDTO
import com.example.demogradlekotlin.dto.ErrorMessage
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.function.Predicate

@RestController
@RequestMapping(value = ["/api/v1/dato"])
@Tag(name = "dato", description = "the dato simple API")
class APIController {
    var listado: MutableList<Dato> = mutableListOf()
    var lastID: Long = 0L
    @GetMapping("/")
    @Operation(
        summary = "show list of dato objects",
        description = "Shows a list of dato in an output array",
        tags = ["dato"]
    )
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Successful operation",
            content = [Content(
                mediaType = "application/json",
                array = ArraySchema(schema = Schema(implementation = Dato::class))
            ), Content(
                mediaType = "application/xml",
                array = ArraySchema(schema = Schema(implementation = Dato::class))
            )]
        )]
    )
    fun index(): List<Dato?> {
        return this.listado
    }

    @GetMapping("/response")
    fun indexResponse(): ResponseEntity<List<Dato?>> {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        return ResponseEntity<List<Dato?>>(
            this.listado,
            headers,
            HttpStatus.OK
        )
    }

    @PostMapping("/")
    @Operation(
        summary = "add a dato object",
        description = "add a dato object with a string input of 80 max characters",
        tags = ["dato"]
    )
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Dato added successfully",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = Dato::class)), Content(
                mediaType = "application/xml",
                schema = Schema(implementation = Dato::class)
            )]
        )]
    )
    fun addDato(
        @Parameter(description = "Created user object") @RequestBody dato: @Valid DatoDTO
    ): Dato {
        lastID++
        val d: Dato = Dato()
        d.id=lastID
        d.cadena=dato.cadena
        listado.add(d)
        return d
    }

    @PostMapping("/response")
    fun addDatoResponse(@RequestBody dato: @Valid DatoDTO): ResponseEntity<Dato> {
        lastID++
        val d: Dato = Dato()
        d.id=lastID
        d.cadena=dato.cadena
        listado.add(d)
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        return ResponseEntity<Dato>(
            d,
            headers,
            HttpStatus.OK
        )
    }

    @GetMapping("/clear")
    fun clear(): List<Dato?> {
        this.listado = mutableListOf()
        this.lastID = 0L
        return this.listado
    }

    @GetMapping("/{id}")
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Successful operation",
            content = [Content(mediaType = "application/xml", schema = Schema(implementation = Dato::class)), Content(
                mediaType = "application/json",
                schema = Schema(implementation = Dato::class)
            )]
        ), ApiResponse(
            responseCode = "404",
            description = "Invalid input",
            content = [Content(
                mediaType = "application/xml",
                schema = Schema(implementation = ErrorMessage::class)
            ), Content(mediaType = "application/json", schema = Schema(implementation = ErrorMessage::class))]
        )]
    )
    fun showDatoById(@PathVariable("id") id: Long?): ResponseEntity<Dato> {
        val d: Dato? = listado
            .stream()
            .filter(Predicate<Dato?> { dato: Dato? -> dato?.id == id  })
            .findFirst()
            .orElse(null)

        var status = HttpStatus.OK
        if (d == null) {
            status = HttpStatus.NOT_FOUND
        }
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        return ResponseEntity<Dato>(
            d,
            headers,
            status
        )
    }

    @PutMapping(value = ["/{id}"])
    fun editDatoById(
        @PathVariable("id") id: Long,
        @RequestBody datoDTO: DatoDTO
    ): ResponseEntity<Dato> {
        val d: Dato? = listado.stream().filter { elemento: Dato? ->
            elemento?.id == id
        }.findFirst().orElse(null)
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        var status = HttpStatus.OK
        var dato: Dato = Dato()
        if (d != null) {
            val index = listado.indexOf(d)
            dato = Dato(datoDTO!!)
            dato.id=id
            listado[index] = dato
        } else {
            status = HttpStatus.NOT_FOUND
        }
        return ResponseEntity<Dato>(
            dato,
            headers,
            status
        )
    }

    //    @DeleteMapping(value = "/{id}")
    //    public ResponseEntity<Dato> deleteDatoById(@PathVariable Long id){
    //        Dato d = this.listado.stream().filter(elemento ->
    //                elemento.getId().equals(id)).findFirst().orElse(null);
    //
    //
    //        HttpHeaders headers = new HttpHeaders();
    //        headers.setContentType(MediaType.APPLICATION_JSON);
    //        HttpStatus status = HttpStatus.OK;
    //        if (d!=null){
    //            this.listado.remove(d);
    //        }else{
    //            status = HttpStatus.NOT_FOUND;
    //        }
    //        return new ResponseEntity<>(
    //                d,
    //                headers,
    //                status
    //        );
    //    }
    @DeleteMapping(value = ["/{id}"])
    @ApiResponses(
        value = [ApiResponse(
            responseCode = "200",
            description = "Successful operation",
            content = [Content(mediaType = "application/xml", schema = Schema(implementation = Dato::class)), Content(
                mediaType = "application/json",
                schema = Schema(implementation = Dato::class)
            )]
        ), ApiResponse(
            responseCode = "404",
            description = "Object not found",
            content = [Content(
                mediaType = "application/xml",
                schema = Schema(implementation = ErrorMessage::class)
            ), Content(mediaType = "application/json", schema = Schema(implementation = ErrorMessage::class))]
        )]
    )
    fun deleteDatoById(@PathVariable id: Long): ResponseEntity<Dato> {
        val d: Dato? = listado.stream().filter(Predicate<Dato?> { elemento: Dato? ->
            elemento?.id== id
        }).findFirst()
            .orElseThrow<ResourceNotFoundException> {
                ResourceNotFoundException(
                    "Not found with id = $id"
                )
            }


        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val status = HttpStatus.OK

        listado.remove(d)

        return ResponseEntity<Dato>(
            d,
            headers,
            status
        )
    }
}