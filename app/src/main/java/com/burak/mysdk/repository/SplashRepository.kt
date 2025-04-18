package com.burak.mysdk.repository

import com.burak.mysdk.model.AppSettingUIModel


interface SplashRepository {


    suspend fun fetchAppSettings(): List<AppSettingUIModel>


}