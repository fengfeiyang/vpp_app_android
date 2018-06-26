package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class DepositListBean(
    @SerializedName("total") val total: Int,
    @SerializedName("rows") val rows: List<DepositRow>
)