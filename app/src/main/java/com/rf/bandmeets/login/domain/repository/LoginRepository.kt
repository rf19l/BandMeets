package com.rf.bandmeets.login.domain.repository

import com.rf.bandmeets.login.domain.model.Credentials
import com.rf.bandmeets.login.domain.model.LoginResponse
import com.rf.bandmeets.core.data.UseCaseResult

interface LoginRepository {
    suspend fun login(
        credentials: Credentials
    ): UseCaseResult<LoginResponse>
}