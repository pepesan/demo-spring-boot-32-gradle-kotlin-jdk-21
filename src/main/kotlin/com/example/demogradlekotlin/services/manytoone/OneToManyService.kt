package com.example.demogradlekotlin.services.manytoone

import com.example.demogradlekotlin.domain.manytoone.Book
import com.example.demogradlekotlin.domain.manytoone.Gender
import com.example.demogradlekotlin.repositories.manytoone.BookRepository
import com.example.demogradlekotlin.repositories.manytoone.GenderRepository
import jakarta.transaction.Transactional
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OneToManyService @Autowired internal constructor(
    bookRepository: BookRepository,
    genderRepository: GenderRepository
) {
    var bookRepository: BookRepository = bookRepository
    var genderRepository: GenderRepository = genderRepository


    @Transactional
    fun doSomething(): MutableList<Gender?> {
        bookRepository.deleteAll()
        genderRepository.deleteAll()
        var gender: Gender = Gender()
        gender.name="Fantasía"
        genderRepository.save(gender)
        var book: Book = Book()
        book.title="El Color de la Magia"
        gender.books.add(book)
        genderRepository.save(gender)
        book = Book()
        book.title="Mort"
        gender.books.add(book)
        genderRepository.save(gender)
        gender = Gender()
        gender.name="Medieval"
        genderRepository.save(gender)
        gender.books.add(book)
        genderRepository.save(gender)
        return genderRepository.findAll()
    }
}
