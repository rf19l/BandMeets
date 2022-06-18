package com.rf.bandmeets.core.domain

import com.rf.bandmeets.login.domain.repository.DemoLoginRepositoryImplementation
import com.rf.bandmeets.login.domain.repository.DemoTokenRepositoryImplementation
import com.rf.bandmeets.login.domain.repository.LoginRepository
import com.rf.bandmeets.login.domain.repository.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTokenRepository(
        tokenRepository: DemoTokenRepositoryImplementation,
    ): TokenRepository

    @Binds
    abstract fun bindLoginRepository(
        loginRepository: DemoLoginRepositoryImplementation,
    ): LoginRepository

}