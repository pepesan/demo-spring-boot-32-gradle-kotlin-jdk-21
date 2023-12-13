package com.example.demogradlekotlin.controllers

import com.example.demogradlekotlin.dto.Persona
import com.example.demogradlekotlin.dto.Student
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView


@Controller
@RequestMapping(value = ["/form"])
class FormularioController {

    val students: MutableList<Student> = mutableListOf()

    @GetMapping("/student")
    fun createStudentPage(model: Model): String {
        model.addAttribute("studentForm", Student(0L, "",""))
        return "new-student-form"
    }
    @PostMapping("/student")
    fun addStudent(@Valid student: Student, result: BindingResult): ModelAndView {
        val model = ModelAndView()
        this.students.add(student)
        model.viewName = if (result.hasErrors()) "new-student-form" else "student"
        return model
    }
    @GetMapping("/student/{studentId}")
    fun findStudent(@PathVariable("studentId") sId: String, model: Model): String {
        model.addAttribute("student", students.first { it.studentId == sId.toLong() } )
        return "student"
    }
}