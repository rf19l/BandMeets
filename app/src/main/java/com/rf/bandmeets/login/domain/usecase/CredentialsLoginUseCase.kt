package com.rf.bandmeets.login.domain.usecase

import com.rf.bandmeets.core.data.UseCaseResult
import com.rf.bandmeets.login.domain.model.Credentials
import com.rf.bandmeets.login.domain.model.InvalidCredentialsException
import com.rf.bandmeets.login.domain.model.LoginResult
import com.rf.bandmeets.login.domain.repository.LoginRepository
import com.rf.bandmeets.login.domain.repository.TokenRepository
import javax.inject.Inject

class CredentialsLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
    private val tokenRepository: TokenRepository,
) {
    suspend fun login(credentials: Credentials): LoginResult {
        val validationResult = validateCredentials(credentials)

        if (validationResult != null) {
            return validationResult
        }

        return when (val repoResult = loginRepository.login(credentials)) {
            is UseCaseResult.Success -> {
                tokenRepository.storeToken(repoResult.data.token)
                LoginResult.Success
            }
            is UseCaseResult.Error -> {
                loginResultForError(repoResult)
            }
        }
    }

    private fun validateCredentials(credentials: Credentials): LoginResult.Failure.EmptyCredentials? {
        val emptyEmail = credentials.email.value.isEmpty()
        val emptyPassword = credentials.password.value.isEmpty()

        return if (emptyEmail || emptyPassword) {
            LoginResult.Failure.EmptyCredentials(
                emptyEmail = emptyEmail,
                emptyPassword = emptyPassword,
            )
        } else {
            null
        }
    }

    private fun loginResultForError(repoResult: UseCaseResult.Error): LoginResult.Failure {
        return when (repoResult.error) {
            is InvalidCredentialsException -> {
                LoginResult.Failure.InvalidCredentials
            }
            else -> {
                LoginResult.Failure.Unknown
            }
        }
    }

}