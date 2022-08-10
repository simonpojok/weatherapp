package me.simonpojok.authentication

import me.simonpojok.authentication.model.AuthenticationKey

interface AuthenticationKeyProvider {
    fun getAuthenticationKey(): AuthenticationKey
}
