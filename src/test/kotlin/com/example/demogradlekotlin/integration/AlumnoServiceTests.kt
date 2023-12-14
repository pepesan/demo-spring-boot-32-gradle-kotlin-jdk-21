package com.example.demogradlekotlin.integration

import com.example.demogradlekotlin.domain.Alumno
import com.example.demogradlekotlin.repositories.AlumnoRepository
import com.example.demogradlekotlin.services.AlumnoServiceImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness
import java.util.*



@ExtendWith(MockitoExtension::class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AlumnoServiceTests {
    @Mock
    private val alumnoRepository: AlumnoRepository? = null

    @InjectMocks
    private val alumnoService: AlumnoServiceImpl? = null

    private var alumnoInput: Alumno = Alumno()
    private var alumnoOutput: Alumno = Alumno()
    @BeforeEach
    fun setUp() {
        alumnoInput = Alumno()
        alumnoInput.id=1L
        alumnoInput.nombre="David"
        alumnoInput.apellidos="Vaquero"
        alumnoInput.edad=45
    }

    @DisplayName("Test for index method with empty list")
    @Test
    fun givenNothing_whenIndex_thenReturnListOfAlumnoObjects() {
        BDDMockito.given(alumnoRepository?.findAll()).willReturn(mutableListOf<Alumno>())
        val listado: List<Alumno>? = alumnoService?.findAll()
        Assertions.assertEquals(ArrayList<Any>(), listado)
    }

    @DisplayName("Test for save method")
    @Test
    fun givenAlumnoObject_whenAdd_thenReturnAlumnoObject() {
        alumnoOutput = Alumno()
        alumnoOutput.id=1L
        alumnoOutput.nombre="David"
        alumnoOutput.apellidos="Vaquero"
        alumnoOutput.edad=44
        BDDMockito.given(alumnoRepository?.save(alumnoInput)).willReturn(alumnoOutput)

        val alumno: Alumno? = alumnoService?.save(alumnoInput)
        Assertions.assertNotNull(alumno)
        assertEquals(alumnoOutput, alumno)
    }

    @DisplayName("Test for show by id method")
    @Test
    fun givenID_whenFindByID_thenReturnAlumnoObject() {
        alumnoOutput = Alumno()
        alumnoOutput.id=1L
        alumnoOutput.nombre="David"
        alumnoOutput.apellidos="Vaquero"
        alumnoOutput.edad=44
        BDDMockito.given(alumnoRepository?.findById(1L)).willReturn(Optional.ofNullable(alumnoOutput))
        val alumno: Optional<Alumno>? = alumnoService?.findById(1L)
        assertEquals(alumnoOutput, alumno?.get())
    }

    @DisplayName("Test for update by id method")
    @Test
    fun givenIDAndAlumnoObject_whenUpdateByID_thenReturnAlumnoObject() {
        alumnoOutput = Alumno()
        alumnoOutput.id=1L
        alumnoOutput.nombre="David"
        alumnoOutput.apellidos="Vaquero"
        alumnoOutput.edad=44
        BDDMockito.given(alumnoRepository?.findById(1L)).willReturn(Optional.ofNullable(alumnoOutput))
        BDDMockito.given(alumnoRepository?.save(alumnoInput)).willReturn(alumnoOutput)
        val optionalAlumno: Alumno? = alumnoService?.save(alumnoInput)
        assertEquals(alumnoOutput, optionalAlumno)
    }

    @DisplayName("Test for delete by id method")
    @Test
    fun givenID_whenDeleteByID_thenReturnAlumnoObject() {
        alumnoOutput = Alumno()
        alumnoOutput.id=1L
        alumnoOutput.nombre="David"
        alumnoOutput.apellidos="Vaquero"
        alumnoOutput.edad=44
        BDDMockito.given(alumnoRepository?.findById(1L)).willReturn(Optional.ofNullable(alumnoOutput))
        var alumno: Optional<Alumno>? = alumnoService?.findById(1L)
        alumno = alumnoService?.deleteById(1L)
        assertEquals(alumnoOutput, alumno?.get())
    }
}