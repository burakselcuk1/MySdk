package com.burak.mysdk.repository

import com.burak.mysdk.model.AppSettingUIModel
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

}