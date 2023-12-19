package com.example.demogradlekotlin

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
	info = Info(
		title = "Dato API",
		version = "2.0",
		description = "Dato API Demo"))
class DemoGradleKotlin2132Application

fun main(args: Array<String>) {
	runApplication<DemoGradleKotlin2132Application>(*args)
}
