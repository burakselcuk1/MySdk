package com.burak.mysdk.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import android.content.Context
import com.burak.mysdk.network.service.RestApiService
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.burak.mysdk.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY

        }


    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context
        //AuthManager: AuthManager
    ): OkHttpClient {
        return OkHttpClient.Builder()
            //.addInterceptor(AuthorizationInterceptor(AuthManager))
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(request)
            }
            .build()
    }





    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context, client: OkHttpClient): Retrofit {
        val okHttpClient = client.newBuilder()
            .apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(ChuckerInterceptor.Builder(context).build())
                }
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_REST)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRestApiService(retrofit: Retrofit): RestApiService {
        return retrofit.create(RestApiService::class.java)
    }
}