package com.burak.mysdk

import android.content.Context
import com.burak.mysdk.usecase.SplashUseCase
import dagger.hilt.android.EntryPointAccessors

class MySdkInitializer(private val context: Context) {

    companion object {
        @Volatile
        private var INSTANCE: MySdkInitializer? = null

        fun getInstance(context: Context): MySdkInitializer {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: MySdkInitializer(context.applicationContext).also { INSTANCE = it }
            }
        }
    }

    // Hilt EntryPoint ile SDK'nın modüllerinden bağımlılıkları alın
    private val entryPoint = EntryPointAccessors.fromApplication(
        context.applicationContext,
        MySdkEntryPoint::class.java
    )

    /**
     * SplashUseCase oluşturur.
     * @return SplashUseCase instance
     */
    fun createSplashUseCase(): SplashUseCase {
        return entryPoint.splashUseCase()
    }
}

// SDK'nın Hilt giriş noktası
@dagger.hilt.EntryPoint
@dagger.hilt.InstallIn(dagger.hilt.components.SingletonComponent::class)
interface MySdkEntryPoint {
    fun splashUseCase(): SplashUseCase
    // Diğer use case'ler...
}