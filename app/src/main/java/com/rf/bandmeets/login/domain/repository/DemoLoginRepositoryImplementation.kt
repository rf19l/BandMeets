package com.rf.bandmeets.login.domain.repository

import com.rf.bandmeets.core.data.UseCaseResult
import com.rf.bandmeets.login.domain.model.*
import javax.inject.Inject

/**
 * This is a dummy repository to test hilt intergration before data service is set up
 *
 */
class DemoLoginRepositoryImplementation @Inject constructor() : LoginRepository {

    override suspend fun login(credentials: Credentials): UseCaseResult<LoginResponse> {
        val defaultToken = Token(
            AuthToken(""),
            RefreshToken(""),
        )

        val defaultResponse = LoginResponse(defaultToken)

        return UseCaseResult.Success(defaultResponse)
    }
}