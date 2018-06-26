package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName


data class OrderTempInfoBean(
    @SerializedName("weatherUrl") val weatherUrl: String,
    @SerializedName("bean") val bean: Bean
) {
    data class Bean(
        @SerializedName("innerOrderId") val innerOrderId: String,
        @SerializedName("status") val status: String,
        @SerializedName("cityName") val cityName: String,
        @SerializedName("stime") val stime: String,
        @SerializedName("maxTemp") val maxTemp: Any,
        @SerializedName("gmtCreate") val gmtCreate: String,
        @SerializedName("weatherContent") val weatherContent: String,
        @SerializedName("contractContent") val contractContent: String,
        @SerializedName("maxPayout") val maxPayout: Double,
        @SerializedName("orderPrice") val orderPrice: Double,
        @SerializedName("buyCount") val buyCount: Int,
        @SerializedName("payFee") val payFee: Double
    )
}