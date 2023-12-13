package com.example.demogradlekotlin.repositories.manytomany

import com.example.demogradlekotlin.domain.manytomany.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : JpaRepository<Role?, Long?>