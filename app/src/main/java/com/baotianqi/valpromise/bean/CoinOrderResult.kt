package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class CoinOrderResult(
        @SerializedName("totalWin") val totalWin: String,
        @SerializedName("totalOrderAmt") val totalOrderAmt: String,
        @SerializedName("lotteryTime") val lotteryTime: String,
        @SerializedName("msg") val msg: String
)