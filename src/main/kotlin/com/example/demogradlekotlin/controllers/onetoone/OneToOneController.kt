package com.example.demogradlekotlin.controllers.onetoone

import com.example.demogradlekotlin.domain.onetoone.Phone
import com.example.demogradlekotlin.services.onetoone.OneToOneService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/onetoone/")
class OneToOneController @Autowired constructor(
    oneToOneService: OneToOneService
) {
    var oneToOneService: OneToOneService = oneToOneService

    @GetMapping("/")
    fun index(): ResponseEntity<MutableList<Phone?>> {
        return ResponseEntity<MutableList<Phone?>>(
            oneToOneService.doSomething(),
            HttpStatus.OK
        )
    }
}