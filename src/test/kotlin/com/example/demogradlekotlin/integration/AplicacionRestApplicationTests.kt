package com.example.demogradlekotlin.integration

import com.example.demogradlekotlin.controllers.MainController
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions.assertNotNull

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
internal class AplicacionRestApplicationTests {
    // Haciendo una Injección de Dependencias del Controlador en esta clase
    // definir un atributo en la clase que se va a auto cargar
    @Autowired
    private val controller: MainController? = null

    // prueba sobre el controlador
    @Test
    @Throws(Exception::class)
    fun miRestControllerLoads() {
        // el controlador no es null, es decir carga correctamente
        assertNotNull(controller)
    }

    // Cargar el gestor de peticiones a la aplicación Web
    // hace una especie de Mock que carga la aplicación y hace peticioens
    @Autowired
    private val mockMvc: MockMvc? = null
    @Test
    @Throws(Exception::class)
    fun shouldReturnHello() {
        // realizar una petición
        mockMvc!!.perform( // hacer un método get en la petición
            // indicando la ruta de acceso
            MockMvcRequestBuilders.get("/")
        ) // imprimir por pantalla el resultado
            .andDo(MockMvcResultHandlers.print()) // comprobamos que el status es 200 OK
            .andExpect(MockMvcResultMatchers.status().isOk()) // comprobamos que el contenido es lo que esperamos
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hola Mundo")))
    }
}