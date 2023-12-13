package com.example.demogradlekotlin.repositories.herencia

import com.example.demogradlekotlin.domain.herencia.Ordenador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "ordenadores", collectionResourceRel = "ordenadores", exported = false)
interface OrdenadorRepository : JpaRepository<Ordenador?, Long?>