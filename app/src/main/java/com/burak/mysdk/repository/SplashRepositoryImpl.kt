package com.burak.mysdk.repository

import com.burak.mysdk.model.AppSettingUIModel
import com.burak.mysdk.model.HeaderBannerUiModel
import com.burak.mysdk.model.LocalizationUiModel
import com.burak.mysdk.model.SplashUiMapper
import com.burak.mysdk.network.service.RestApiService
import javax.inject.Inject


class SplashRepositoryImpl @Inject constructor(
    private val service: RestApiService,
    private val uiMapper: SplashUiMapper
) : SplashRepository {

    override suspend fun fetchAppSettings(): List<AppSettingUIModel> {
        val response = service.getAppSettings()
        return response.map { uiMapper.mapToUIModel(it) }
    }

    override suspend fun getHeaderBanner(): List<HeaderBannerUiModel>  {
        val response = service.getHeaderBanner()
        return uiMapper.mapToHeaderUiModel(response)
    }

    override suspend fun getLocalizations(language: String): List<LocalizationUiModel> {
        val response = service.getLocalizations(language)
        return response.map { uiMapper.mapToLocalization(it) }
    }

}