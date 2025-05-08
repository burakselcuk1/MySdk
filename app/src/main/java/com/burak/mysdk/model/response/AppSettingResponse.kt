package com.burak.mysdk.model.response

data class AppSettingResponse(
    val name: String,
    val value: String,
    val storeId: String?,
    val locales: List<Any>,
    val genericAttributes: List<Any>,
    val id: String
)

data class HeaderBannerResponse(
    val schemaId: String,
    val items: List<HeaderBannerItem>,
    val backgroundColor: String,
    val isPublished: Boolean,
    val schemaName: String
)

data class HeaderBannerItem(
    val schemaId: String,
    val bannerText: String,
    val textColor: String,
    val fontSize: String,
    val schemaName: String
)

data class LocalizationResponse(
    val key: String,
    val value: String?
)