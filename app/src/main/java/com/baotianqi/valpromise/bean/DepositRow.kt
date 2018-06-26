package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName
data class DepositRow(
    @SerializedName("id") val id: Int,
    @SerializedName("cashNo") val cashNo: String,
    @SerializedName("vpp") val vpp: Int,
    @SerializedName("customerId") val customerId: Int,
    @SerializedName("payerAddress") val payerAddress: String,
    @SerializedName("payeeAddress") val payeeAddress: String,
    @SerializedName("description") val description: Any,
    @SerializedName("gmtCreate") val gmtCreate: String,
    @SerializedName("gmtModified") val gmtModified: Any,
    @SerializedName("timastamp") val timastamp: Long,
    @SerializedName("fromBlock") val fromBlock: Int
)