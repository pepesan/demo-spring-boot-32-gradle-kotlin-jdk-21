package com.example.demogradlekotlin.repositories.manytomany

import com.example.demogradlekotlin.domain.manytomany.Noticia
import org.springframework.data.jpa.repository.JpaRepository

interface NoticiaRepository : JpaRepository<Noticia?, Long?>