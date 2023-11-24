package com.adriel.springgraphqlexample.account

import com.adriel.springgraphqlexample.user.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "ACCOUNT")
data class Account(
    @Id val id: String?,
    val owner: String,
    val users: List<User>
)
