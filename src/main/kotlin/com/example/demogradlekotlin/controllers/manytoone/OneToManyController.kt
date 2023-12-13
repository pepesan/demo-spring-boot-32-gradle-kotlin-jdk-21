package com.example.demogradlekotlin.controllers.manytoone

import com.example.demogradlekotlin.domain.manytoone.Gender
import com.example.demogradlekotlin.services.manytoone.OneToManyService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/onetomany")
class OneToManyController @Autowired internal constructor(oneToManyService: OneToManyService) {
    var oneToManyService: OneToManyService = oneToManyService

    @GetMapping("/")
    fun index(): ResponseEntity<MutableList<Gender?>> {
        return ResponseEntity<MutableList<Gender?>>(
            oneToManyService.doSomething(),
            HttpStatus.OK
        )
    }
}
