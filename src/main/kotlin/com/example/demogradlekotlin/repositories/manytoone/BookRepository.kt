package com.example.demogradlekotlin.repositories.manytoone

import com.example.demogradlekotlin.domain.manytoone.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book?, Long?>