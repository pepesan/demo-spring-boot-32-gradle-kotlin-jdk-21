package com.example.demogradlekotlin.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/v1/main", "/", "/main"])
class MainController {
    @GetMapping("/")
    fun main(): String {
        return "<h1>Hola Mundo</h1>"
    }
}