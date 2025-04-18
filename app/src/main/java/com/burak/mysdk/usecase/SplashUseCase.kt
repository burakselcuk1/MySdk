package com.burak.mysdk.usecase

import com.burak.mysdk.model.AppSettingUIModel
import com.burak.mysdk.repository.SplashRepository
import javax.inject.Inject


class SplashUseCase @Inject constructor(
    private val repository: SplashRepository
) {
    suspend fun getAppSettings(): List<AppSettingUIModel> {
        return repository.fetchAppSettings()
    }
}
