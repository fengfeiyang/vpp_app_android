package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class PayoutHistoryBean(
    @SerializedName("total") val total: Int,
    @SerializedName("pageSize") val pageSize: Int,
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("rows") val rows: List<PayoutHistoryRow>
)