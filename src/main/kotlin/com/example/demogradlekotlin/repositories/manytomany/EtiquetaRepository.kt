package com.example.demogradlekotlin.repositories.manytomany

import com.example.demogradlekotlin.domain.manytomany.Etiqueta
import org.springframework.data.jpa.repository.JpaRepository

interface EtiquetaRepository : JpaRepository<Etiqueta?, Long?>