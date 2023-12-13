package com.example.demogradlekotlin.repositories.onetoone

import com.example.demogradlekotlin.domain.onetoone.PhoneDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PhoneDetailsRepository : JpaRepository<PhoneDetails?, Long?>