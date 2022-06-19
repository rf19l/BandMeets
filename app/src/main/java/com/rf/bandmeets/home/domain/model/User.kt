package com.rf.bandmeets.home.domain.model

@JvmInline
value class Email(val value: String)

@JvmInline
value class Username(val value:String)

data class User(
    val email:Email = Email(""),
    val username:Username = Username("")
)
