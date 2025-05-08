package com.burak.mysdk.usecase

import com.burak.mysdk.model.AppSettingUIModel
import com.burak.mysdk.model.HeaderBannerUiModel
import com.burak.mysdk.model.LocalizationUiModel
import com.burak.mysdk.repository.SplashRepository
import javax.inject.Inject


class SplashUseCase @Inject constructor(
    private val repository: SplashRepository
) {
    suspend fun getAppSettings(): List<AppSettingUIModel> {
        return repository.fetchAppSettings()
    }

    suspend fun getHeaderBanner(): List<HeaderBannerUiModel> {
        return repository.getHeaderBanner()
    }

    suspend fun getLocalizations(language: String): List<LocalizationUiModel> {
        return repository.getLocalizations(language)
    }
}
