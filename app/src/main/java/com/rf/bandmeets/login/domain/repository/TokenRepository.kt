package com.rf.bandmeets.login.domain.repository

import com.rf.bandmeets.login.domain.model.Token

interface TokenRepository {
    suspend fun storeToken(
        token: Token,
    )

    suspend fun fetchToken(): Token?

}