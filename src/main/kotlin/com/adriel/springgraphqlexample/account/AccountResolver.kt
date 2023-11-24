package com.adriel.springgraphqlexample.account

import com.adriel.springgraphqlexample.user.UserRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class AccountResolver(
    private val accountRepository: AccountRepository,
    private val userRepository: UserRepository
) {

    @QueryMapping
    fun getAllAccounts(): List<Account> {
        return accountRepository.findAll()
    }

    @QueryMapping
    fun getAccountById(@Argument id: String): Account {
        return accountRepository.findById(id).orElseThrow { NoSuchElementException("Not Found!") }
    }

    @MutationMapping
    fun saveAccount(@Argument account: AccountInput): Account {
        val users = userRepository.findAllById(account.usersId)
        val accountToSave = Account(null, account.owner, users)
        return accountRepository.save(accountToSave)
    }

}

class AccountInput(
    val owner: String,
    val usersId: List<String>
)
