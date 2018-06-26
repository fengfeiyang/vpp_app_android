package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName
data class PaymentHistoryRow(
    @SerializedName("innerOrderId") val innerOrderId: String,
    @SerializedName("payFee") val payFee: Double,
    @SerializedName("productName") val productName: String,
    @SerializedName("payTime") val payTime: String,
    @SerializedName("productId") val productId: Any
)