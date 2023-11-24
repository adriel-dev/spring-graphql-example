package com.adriel.springgraphqlexample.user

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class UserResolver(
    private val userRepository: UserRepository
) {

    @QueryMapping
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @QueryMapping
    fun getUserById(@Argument id: String): User {
        return userRepository.findById(id).orElseThrow { NoSuchElementException("Not Found!") }
    }

    @MutationMapping
    fun saveUser(@Argument user: UserInput): User {
        val userToSave = User(null, user.username, user.password)
        return userRepository.save(userToSave)
    }

}

class UserInput(
    val username: String,
    val password: String
)
