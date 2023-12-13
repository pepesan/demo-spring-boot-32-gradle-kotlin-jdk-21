package com.example.demogradlekotlin.controllers.onetoone

import com.example.demogradlekotlin.domain.onetoone.Address
import com.example.demogradlekotlin.domain.onetoone.Order
import com.example.demogradlekotlin.services.onetoone.OneToOneBidirectionalService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/onetoonebi")
class OneToOneBidirectionalController @Autowired constructor(
    oneToOneBidirectionalService: OneToOneBidirectionalService
) {
    var oneToOneBidirectionalService: OneToOneBidirectionalService = oneToOneBidirectionalService

    @GetMapping("/")
    fun index(): ResponseEntity<MutableList<Order?>> {
        return ResponseEntity<MutableList<Order?>>(
            oneToOneBidirectionalService.doSomething(),
            HttpStatus.OK
        )
    }

    @GetMapping("/address")
    fun indexAddress(): ResponseEntity<MutableList<Address?>> {
        return ResponseEntity<MutableList<Address?>>(
            oneToOneBidirectionalService.doSomethingAddress(),
            HttpStatus.OK
        )
    }
}