package com.burak.mysdk

import android.content.Context
import com.burak.mysdk.model.SplashUiMapper
import com.burak.mysdk.network.service.RestApiService
import com.burak.mysdk.repository.SplashRepository
import com.burak.mysdk.repository.SplashRepositoryImpl
import com.burak.mysdk.usecase.SplashUseCase
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.burak.mysdk.BuildConfig

/**
 * SDK başlatıcı sınıfı.
 * Bu sınıf, SDK'nın bağımlılıklarını manuel olarak oluşturarak UseCase'lere kolay erişim sağlar.
 */
class MySdkInitializer(private val context: Context) {

    private val okHttpClient: OkHttpClient
    private val apiService: RestApiService
    private val splashUiMapper: SplashUiMapper
    private val splashRepository: SplashRepository

    init {
        // OkHttp client oluştur
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val builder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(request)
            }


        okHttpClient = builder.build()

        // REST API servisini oluştur
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_REST)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(RestApiService::class.java)

        // Mapper oluştur
        splashUiMapper = SplashUiMapper()

        // Repository oluştur
        splashRepository = SplashRepositoryImpl(apiService, splashUiMapper)
    }

    /**
     * SplashUseCase oluşturur.
     * @return SplashUseCase instance
     */
    fun createSplashUseCase(): SplashUseCase {
        return SplashUseCase(splashRepository)
    }

    // Diğer UseCase'ler için benzer metodlar buraya eklenebilir
}