package com.burak.mysdk.repository

import com.burak.mysdk.model.AppSettingUIModel
import com.burak.mysdk.model.HeaderBannerUiModel
import com.burak.mysdk.model.LocalizationUiModel


interface SplashRepository {


    suspend fun fetchAppSettings(): List<AppSettingUIModel>

    suspend fun getHeaderBanner(): List<HeaderBannerUiModel>

    suspend fun getLocalizations(language: String): List<LocalizationUiModel>


}