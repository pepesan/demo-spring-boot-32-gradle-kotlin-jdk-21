package com.example.demogradlekotlin.controllers.manytomany

import com.example.demogradlekotlin.domain.manytomany.Role
import com.example.demogradlekotlin.domain.manytomany.User
import com.example.demogradlekotlin.services.manytomany.ManyToManyBidirectionalService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manytomany")
class ManyToManyBidirectionalController @Autowired internal constructor(
    manyToManyService: ManyToManyBidirectionalService
) {
    var manyToManyService: ManyToManyBidirectionalService = manyToManyService

    @GetMapping("/")
    fun index(): ResponseEntity<MutableList<User?>> {
        return ResponseEntity<MutableList<User?>>(
            manyToManyService.doSomething(),
            HttpStatus.OK
        )
    }

    @GetMapping("/roles")
    fun indexRoles(): ResponseEntity<MutableList<Role?>> {
        return ResponseEntity<MutableList<Role?>>(
            manyToManyService.doSomethingRoles(),
            HttpStatus.OK
        )
    }
}
