package com.rf.bandmeets.login.domain.repository

import com.rf.bandmeets.login.domain.model.Token
import javax.inject.Inject

class DemoTokenRepositoryImplementation @Inject constructor() : TokenRepository {
    override suspend fun storeToken(token: Token) {
        // No-Op
    }

    override suspend fun fetchToken(): Token? {
        return null
    }
}