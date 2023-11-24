package com.adriel.springgraphqlexample.user

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "USER")
data class User(
    @Id val id: String?,
    val username: String,
    val password: String
)
