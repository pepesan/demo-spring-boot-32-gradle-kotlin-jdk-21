package com.example.demogradlekotlin.aceptacion

import com.example.demogradlekotlin.dto.Dato
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Tag("Aceptance")
class HttpRequestTest {
    @Value(value = "\${local.server.port}")
    private val port = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null
    private var apiURL: String? = null

    @BeforeEach
    fun setUp() {
        apiURL = "http://localhost:$port/"
        restTemplate!!.getForObject(
            apiURL + "api/v1/dato/clear",
            String::class.java
        )
    }

    @Test
    @Throws(Exception::class)
    fun greetingShouldReturnDefaultMessage() {
        Assertions.assertThat(
            restTemplate!!.getForObject(
                apiURL+"main/",
                String::class.java
            )
        ).contains("Hola Mundo")
    }

    @Test
    fun testEnviarDatosAlApi() {
        // Crear un objeto MyObject con la cadena que deseas enviar
        val dato: Dato = Dato()
        dato.cadena="Ejemplo de cadena"

        // Configurar las cabeceras
        val headers = HttpHeaders()
        headers["Content-Type"] = "application/json"

        // Crear la entidad HTTP con el objeto y las cabeceras
        val requestEntity: HttpEntity<Dato> = HttpEntity<Dato>(dato, headers)

        // Crear un objeto RestTemplate
        val restTemplate = RestTemplate()

        this.apiURL += "api/v1/dato/" // Realizar la solicitud POST al API REST
        val responseEntity: ResponseEntity<Dato> = restTemplate.exchange(
            this.apiURL!!,
            HttpMethod.POST,
            requestEntity,
            Dato::class.java
        )

        // Verificar que la respuesta del servidor sea exitosa (código 2xx)
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode())

        // Puedes verificar más cosas según tus necesidades, por ejemplo, el contenido de la respuesta
        val responseBody: Dato? = responseEntity.getBody()
        assertEquals("Ejemplo de cadena", responseBody?.cadena)
        assertEquals(1, responseBody?.id)
    }

    @Test
    fun testEnviarDatosAlApiWebFlux() {
        // Crear un objeto MyObject con la cadena que deseas enviar
        val dato: Dato = Dato()
        dato.cadena="Ejemplo de cadena"

        // Configurar las cabeceras
        val headers = HttpHeaders()
        headers["Content-Type"] = "application/json"

        // Crear la entidad HTTP con el objeto y las cabeceras
        val requestEntity: HttpEntity<Dato> = HttpEntity<Dato>(dato, headers)

        // Crear un objeto WebClient
        val webClient: WebClient = WebClient.create(this.apiURL!!)

        // Realizar la solicitud POST al API REST usando WebClient
        val responseEntity: ResponseEntity<Dato>? = webClient.post()
            .uri("/api/v1/dato/") // Puedes cambiar la URI según tu necesidad
            .body(BodyInserters.fromValue(dato))
            .retrieve()
            .toEntity(Dato::class.java)
            .block() // Espera la respuesta síncronamente

        // Verificar que la respuesta del servidor sea exitosa (código 2xx)
        assertEquals(HttpStatus.OK, responseEntity?.getStatusCode())

        // Puedes verificar más cosas según tus necesidades, por ejemplo, el contenido de la respuesta
        val responseBody: Dato? = responseEntity?.getBody()
        org.junit.jupiter.api.Assertions.assertNotNull(responseBody)
        assertEquals("Ejemplo de cadena", responseBody?.cadena)
        assertEquals(1, responseBody?.id)
    }
}