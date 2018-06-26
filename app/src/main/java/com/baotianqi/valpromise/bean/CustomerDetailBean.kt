package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class CustomerDetailBean(
    @SerializedName("id") val id: String,
    @SerializedName("walletAddress") val walletAddress: String,
    @SerializedName("balance") val balance: String,
    @SerializedName("cashAmount") val cashAmount: Double
)