package com.burak.mysdk.network.service

import com.burak.mysdk.common.ApiEndpoints.Companion.GET_APP_HEADER_BANNER
import com.burak.mysdk.common.ApiEndpoints.Companion.GET_APP_SETTINGS
import com.burak.mysdk.common.ApiEndpoints.Companion.GET_LOCALIZATIONS
import com.burak.mysdk.common.QueryParams
import com.burak.mysdk.model.response.AppSettingResponse
import com.burak.mysdk.model.response.HeaderBannerResponse
import com.burak.mysdk.model.response.LocalizationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiService {

//    @GET(GET_LOCALIZATIONS)
//    suspend fun getLocalizations(
//        @Query(QueryParams.LANGUAGE) language: String
//    ): List<LocalizationResponse>

    @GET(GET_LOCALIZATIONS)
    suspend fun getLocalizations(
        @Query(QueryParams.LANGUAGE) language: String
    ): List<LocalizationResponse>

    @GET(GET_APP_SETTINGS)
    suspend fun getAppSettings(): List<AppSettingResponse>

    @GET(GET_APP_HEADER_BANNER)
    suspend fun getHeaderBanner(
        @Query(QueryParams.SCHEMA_NAME) schemaName: String = "app-header-banner",
        @Query(QueryParams.COUNTRY) country: String = "TR",
        @Query(QueryParams.LANGUAGE) language: String = "tr"
    ): List<HeaderBannerResponse>

}