package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class CoinGuessBean(
    @SerializedName("productId") val productId: String,
    @SerializedName("dataSource") val dataSource: String,
    @SerializedName("minBet") val minBet: Int,
    @SerializedName("maxBet") val maxBet: Long,
    @SerializedName("lotteryInterval") val lotteryInterval: Int,
    @SerializedName("profitRate") val profitRate: Double,
    @SerializedName("orderDeadline") val orderDeadline: Int
)