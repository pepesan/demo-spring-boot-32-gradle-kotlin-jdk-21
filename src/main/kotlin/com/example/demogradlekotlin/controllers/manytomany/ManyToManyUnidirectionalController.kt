package com.example.demogradlekotlin.controllers.manytomany

import com.example.demogradlekotlin.domain.manytomany.Noticia
import com.example.demogradlekotlin.services.manytomany.ManyToManyUnidirectionalService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manytomanyuni")
class ManyToManyUnidirectionalController @Autowired constructor(service: ManyToManyUnidirectionalService) {
    private val service: ManyToManyUnidirectionalService = service

    @GetMapping("/")
    fun index(): ResponseEntity<MutableList<Noticia?>> {
        return ResponseEntity<MutableList<Noticia?>>(
            service.doSomething(),
            HttpStatus.OK
        )
    }
}
