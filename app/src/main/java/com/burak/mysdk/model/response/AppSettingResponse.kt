package com.burak.mysdk.model.response

data class AppSettingResponse(
    val name: String,
    val value: String,
    val storeId: String?,
    val locales: List<Any>,
    val genericAttributes: List<Any>,
    val id: String
)