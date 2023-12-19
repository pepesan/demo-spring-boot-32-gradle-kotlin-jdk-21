package com.example.demogradlekotlin.controllers

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping(value = ["/mvc"])
@Tag(
    name = "mvc",
    description = "MVC API Sample")
class MVCController {
    // inject via application.properties
    @Value("\${welcome.message}")
    private val message: String? = null

    private val tasks: List<String> = mutableListOf("a", "b", "c", "d", "e", "f", "g")
    @GetMapping
    fun main(model: Model): String {
        model.addAttribute("message", message)
        model.addAttribute("tasks", tasks)

        return "welcome" //view
    }
    @GetMapping("/{id}")
    fun miPost(@PathVariable("id") id: String?, model: Model): String {
        model.addAttribute("id", id)
        return "params"
    }
    @PostMapping
    fun miPost(model: Model, @RequestParam("id") id: String?): String {
        model.addAttribute("id", id)
        return "params"
    }

}