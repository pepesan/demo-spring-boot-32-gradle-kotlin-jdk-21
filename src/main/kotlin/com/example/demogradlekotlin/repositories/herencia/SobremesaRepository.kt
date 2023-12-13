package com.example.demogradlekotlin.repositories.herencia

import com.example.demogradlekotlin.domain.herencia.Sobremesa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface SobremesaRepository : JpaRepository<Sobremesa?, Long?>