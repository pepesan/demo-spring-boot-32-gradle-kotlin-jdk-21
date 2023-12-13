package com.example.demogradlekotlin.repositories.onetoone

import com.example.demogradlekotlin.domain.onetoone.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressesRepository : JpaRepository<Address?, Long?>