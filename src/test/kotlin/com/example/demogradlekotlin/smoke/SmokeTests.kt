package com.example.demogradlekotlin.smoke

import com.example.demogradlekotlin.controllers.MainController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class SmokeTests {
    @Autowired
    private val controller: MainController? = null

    @Test
    @Throws(Exception::class)
    fun miRestControllerLoads() {
        assertThat(controller).isNotNull()
    }
}