package com.example.demogradlekotlin.repositories.onetoone

import com.example.demogradlekotlin.domain.onetoone.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order?, Long?>