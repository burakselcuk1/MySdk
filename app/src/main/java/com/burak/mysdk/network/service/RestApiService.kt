package com.burak.mysdk.network.service

import com.burak.mysdk.common.ApiEndpoints.Companion.GET_APP_SETTINGS
import com.burak.mysdk.common.ApiEndpoints.Companion.GET_LOCALIZATIONS
import com.burak.mysdk.common.QueryParams
import com.burak.mysdk.model.response.AppSettingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiService {

//    @GET(GET_LOCALIZATIONS)
//    suspend fun getLocalizations(
//        @Query(QueryParams.LANGUAGE) language: String
//    ): List<LocalizationResponse>

    @GET(GET_APP_SETTINGS)
    suspend fun getAppSettings(): List<AppSettingResponse>

}