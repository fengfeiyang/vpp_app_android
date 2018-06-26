package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class WalletAddressBean(
    @SerializedName("id") val id: Int,
    @SerializedName("walletAddress") val walletAddress: String,
    @SerializedName("walletCode") val walletCode: String
)