package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class OrderListBean(
    @SerializedName("total") val total: Int,
    @SerializedName("pageSize") val pageSize: Int,
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("rows") val rows: List<Row>
) {
    data class Row(
        @SerializedName("innerOrderId") val innerOrderId: String,
        @SerializedName("title") val title: String,
        @SerializedName("gmtCreate") val gmtCreate: String,
        @SerializedName("content") val content: String,
        @SerializedName("amount") val amount: String,
        @SerializedName("status") val status: String
    )
}