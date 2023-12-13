package com.example.demogradlekotlin.repositories.manytomany

import com.example.demogradlekotlin.domain.manytomany.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User?, Long?>