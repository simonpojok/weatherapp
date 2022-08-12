package me.simonpojok.authentication

import me.simonpojok.authentication.model.AuthenticationKey

interface AuthenticationKeyProvider {
    fun getAuthenticationKey(): AuthenticationKey
}


class AuthenticationKeyDataProvider(): AuthenticationKeyProvider {
    override fun getAuthenticationKey() = AuthenticationKey(
        apiKey = "66d98186ffe30de00dd4fbd6ca95286b"
    )
}
