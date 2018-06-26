package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class OrderCoinInfoBean(
        @SerializedName("id") val id: Int,
        @SerializedName("customerId") val customerId: Int,
        @SerializedName("orderId") val orderId: String,
        @SerializedName("targetId") val targetId: String,
        @SerializedName("orderAmt") val orderAmt: Int,
        @SerializedName("orderDir") val orderDir: Int,
        @SerializedName("orderTs") val orderTs: String,
        @SerializedName("orderPrice") val orderPrice: Double,
        @SerializedName("profit") val profit: Double,
        @SerializedName("lotteryTime") val lotteryTime: String,
        @SerializedName("actualLotteryTime") val actualLotteryTime: String,
        @SerializedName("actualPrice") val actualPrice: Double,
        @SerializedName("status") val status: Int,
        @SerializedName("rewardFlg") val rewardFlg: Int,
        @SerializedName("description") val description: Any,
        @SerializedName("gmtCreate") val gmtCreate: String,
        @SerializedName("gmtModified") val gmtModified: String
)