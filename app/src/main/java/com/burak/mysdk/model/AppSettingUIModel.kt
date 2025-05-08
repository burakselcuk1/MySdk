package com.burak.mysdk.model

data class AppSettingUIModel(
    val displayName: String,
    val displayValue: String
)

data class HeaderBannerUiModel(
    val backgroundColor: String,
    val items: List<HeaderBannerItemUiModel>
)

data class HeaderBannerItemUiModel(
    val text: String,
    val textColor: String,
    val fontSize: Int
)

data class LocalizationUiModel(
    val key: String,
    val value: String?
)