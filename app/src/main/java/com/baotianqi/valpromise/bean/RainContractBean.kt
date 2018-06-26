package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class RainContractBean(
        @SerializedName("contractId") val contractId: String,
        @SerializedName("cityId") val cityId: String,
        @SerializedName("maxBuyCount") val maxBuyCount: Int,
        @SerializedName("contractTime") val contractTime: String,
        @SerializedName("explainFirst") val explainFirst: String,
        @SerializedName("explainSecond") val explainSecond: String,
        @SerializedName("threshold") val threshold: Double,
        @SerializedName("price") val price: Double,
        @SerializedName("payout") val payout: Double
)