package com.burak.mysdk.model

import com.burak.mysdk.model.response.AppSettingResponse
import com.burak.mysdk.model.response.HeaderBannerResponse
import com.burak.mysdk.model.response.LocalizationResponse


class SplashUiMapper {

    fun mapToUIModel(appSetting: AppSettingResponse): AppSettingUIModel {
        return AppSettingUIModel(
            displayName = appSetting.name.orEmptyString(),
            displayValue = appSetting.value.orEmptyString()
        )
    }

    fun mapToHeaderUiModel(response: List<HeaderBannerResponse>): List<HeaderBannerUiModel> {
        return response.map {
            HeaderBannerUiModel(
                backgroundColor = it.backgroundColor.orEmptyString(),
                items = it.items.map { item ->
                    HeaderBannerItemUiModel(
                        text = item.bannerText.orEmptyString(),
                        textColor = item.textColor.orEmptyString(),
                        fontSize = 12
                    )
                }
            )
        }
    }
    fun mapToLocalization(localization: LocalizationResponse): LocalizationUiModel {
        return LocalizationUiModel(
            key = localization.key,
            value = localization.value
        )
    }
}
fun String?.orEmptyString(): String = this ?: ""
