package com.example.demogradlekotlin.services.manytomany

import com.example.demogradlekotlin.domain.manytomany.Role
import com.example.demogradlekotlin.domain.manytomany.User
import com.example.demogradlekotlin.repositories.manytomany.RoleRepository
import com.example.demogradlekotlin.repositories.manytomany.UserRepository
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ManyToManyBidirectionalService @Autowired internal constructor(
    userRepository: UserRepository,
    roleRepository: RoleRepository
) {
    var userRepository: UserRepository = userRepository
    var roleRepository: RoleRepository = roleRepository

    @Transactional
    fun deleteAll() {
        // eliminate all the references to the roles
        userRepository.findAll().stream()
            .forEach { user ->
                user?.roles?.clear()
                if (user != null) {
                    userRepository.save(user)
                }
            }
        roleRepository.findAll().stream()
            .forEach { role ->
                role?.users?.clear()
                if (role != null) {
                    roleRepository.save(role)
                }
            }
    }

    fun doSomething(): MutableList<User?> {
        this.deleteAll()
        val user: User = User()
        user.firstName="David"
        userRepository.save(user)
        val role: Role = Role()
        role.name="Admin"
        roleRepository.save(role)
        user.roles.add(role)
        userRepository.save(user)
        return userRepository.findAll()
    }

    fun doSomethingRoles(): MutableList<Role?> {
        this.deleteAll()
        val user: User = User()
        user.firstName="David"
        userRepository.save(user)
        val role: Role = Role()
        role.name="Admin"
        roleRepository.save(role)
        user.roles.add(role)
        userRepository.save(user)
        return roleRepository.findAll()
    }
}