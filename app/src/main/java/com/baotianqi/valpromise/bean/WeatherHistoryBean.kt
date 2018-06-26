package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class WeatherHistoryBean(
        @SerializedName("total") val value: Double,
        @SerializedName("pageSize") val time: String,
        @SerializedName("currentPage") val type: String
)