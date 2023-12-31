package com.example.demogradlekotlin.controllers

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/main", "/", "/main"])
@Tag(
    name = "main",
    description = "Rest API Sample")
class MainController {
    @GetMapping("/")
    fun main(): String {
        return "<h1>Hola Mundo</h1>"
    }
}