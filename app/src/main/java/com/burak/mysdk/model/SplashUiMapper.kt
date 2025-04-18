package com.burak.mysdk.model

import com.burak.mysdk.model.response.AppSettingResponse


class SplashUiMapper {



    fun mapToUIModel(appSetting: AppSettingResponse): AppSettingUIModel {
        return AppSettingUIModel(
            displayName = appSetting.name.orEmptyString(),
            displayValue = appSetting.value.orEmptyString()
        )
    }

}
fun String?.orEmptyString(): String = this ?: ""
