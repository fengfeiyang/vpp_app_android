package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName
data class PayoutHistoryRow(
    @SerializedName("innerOrderId") val innerOrderId: String,
    @SerializedName("payoutTime") val payoutTime: String,
    @SerializedName("payoutFee") val payoutFee: Int
)