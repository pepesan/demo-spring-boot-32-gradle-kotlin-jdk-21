package com.example.demogradlekotlin.relations

import com.example.demogradlekotlin.domain.manytomany.Role
import com.example.demogradlekotlin.domain.manytomany.User
import com.example.demogradlekotlin.repositories.manytomany.RoleRepository
import com.example.demogradlekotlin.repositories.manytomany.UserRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest


@DataJpaTest
class ManyToManyBidirectionalTests {
    @Autowired
    private val roleRepository: RoleRepository? = null

    @Autowired
    private val userRepository: UserRepository? = null

    @Test
    fun saveRole() {
        val user: User = User()
        user.firstName="pepesan"
        userRepository?.save(user)

        val admin: User = User()
        admin.firstName="admin"
        userRepository?.save(admin)

        val roleAdmin: Role = Role()
        roleAdmin.name="ROLE_ADMIN"

        roleAdmin.users.add(user)
        roleAdmin.users.add(admin)

        roleRepository?.save(roleAdmin)
//        ManyToManyBidirectionalTests.log.info("" + user)
//        ManyToManyBidirectionalTests.log.info("" + admin)
//        ManyToManyBidirectionalTests.log.info("" + roleAdmin)
        val salida = roleAdmin.users.contains(admin)
        assertTrue(salida)
    }

    @Test
    fun fetchRole() {
        val roles: MutableList<Role?>? = roleRepository?.findAll()
        println(roles)
    }
}