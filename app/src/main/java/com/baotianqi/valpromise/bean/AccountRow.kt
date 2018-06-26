package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName
data class AccountRow(
    @SerializedName("id") val id: Int,
    @SerializedName("description") val description: String,
    @SerializedName("withdrawal_address") val withdrawalAddress: String
)