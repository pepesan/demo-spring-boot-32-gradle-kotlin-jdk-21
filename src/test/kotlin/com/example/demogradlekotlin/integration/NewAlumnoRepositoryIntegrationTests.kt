package com.example.demogradlekotlin.integration

import com.example.demogradlekotlin.domain.Alumno
import com.example.demogradlekotlin.repositories.AlumnoRepository
import jakarta.persistence.EntityManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@DataJpaTest
class NewAlumnoRepositoryIntegrationTests {
    @Autowired
    var alumnoRepository: AlumnoRepository? = null

    @Autowired
    private val testEntityManager: TestEntityManager? = null

    @Autowired
    private val dataSource: DataSource? = null

    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null

    @Autowired
    private val entityManager: EntityManager? = null

    @BeforeEach
    fun setup() {
        // given
        var alumno: Alumno = Alumno()
        alumno.nombre="Pepe"
        alumno.edad=21
        testEntityManager!!.persist<Any>(alumno)
        alumno = Alumno()
        alumno.nombre="David"
        alumno.edad=45
        testEntityManager.persist<Any>(alumno)
        entityManager!!.flush()
    }

    @AfterEach
    fun cleanUp() {
        alumnoRepository?.deleteAll()
        alumnoRepository?.flush()
    }

    @Test
    fun findAllReturnAllData() {
        val alumnos: List<Alumno>? = alumnoRepository?.findAll()
        assertEquals(alumnos?.size, 2)
    }

    @Test
    fun findByNombre() {
        val alumnos: List<Alumno?>? = alumnoRepository?.findByNombre("David")
        assertThat(alumnos).hasSize(1)
        val nombre = alumnos?.get(0)?.nombre!!
        assertEquals(nombre, "David")
    }

    @Test
    fun findByEdad() {
        val alumnos: List<Alumno?>? = alumnoRepository?.findByEdad(45)
        assertThat(alumnos).hasSize(1)
        val nombre = alumnos?.get(0)?.nombre!!
        assertEquals(nombre, "David")
    }

    @Test
    fun findByQuery() {
        val alumnos: List<Alumno?>? = alumnoRepository?.findAlumnosByName("David")
        assertThat(alumnos).hasSize(1)
        val nombre = alumnos?.get(0)?.nombre!!
        assertEquals(nombre, "David")
    }

    @Test
    fun findByNamedQuery() {
        val alumnos: List<Alumno?>? = alumnoRepository?.searchByNamedQueryName("David")
        assertThat(alumnos).hasSize(1)
        val nombre = alumnos?.get(0)?.nombre!!
        assertEquals(nombre, "David")
    }
}