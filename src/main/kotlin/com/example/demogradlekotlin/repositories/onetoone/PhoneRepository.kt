package com.example.demogradlekotlin.repositories.onetoone

import com.example.demogradlekotlin.domain.onetoone.Phone
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneRepository : JpaRepository<Phone?, Long?>