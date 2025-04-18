package com.burak.mysdk.splash


import androidx.annotation.Keep
import com.burak.mysdk.model.SplashUiMapper
import com.burak.mysdk.network.service.RestApiService
import com.burak.mysdk.repository.SplashRepository
import com.burak.mysdk.repository.SplashRepositoryImpl
import com.burak.mysdk.usecase.SplashUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SplashModule {

    @Keep
    @Provides
    @Singleton
    fun provideSplashRepository(
        graphQLService: RestApiService,
        uiMapper: SplashUiMapper
    ): SplashRepository {
        return SplashRepositoryImpl(graphQLService,uiMapper)
    }

    @Keep
    @Provides
    @Singleton
    fun provideSplashUseCase(
        repository: SplashRepository
    ): SplashUseCase {
        return SplashUseCase(repository)
    }

    @Keep
    @Provides
    @Singleton
    fun productSplashUiMapper(): SplashUiMapper {
        return SplashUiMapper()
    }
}