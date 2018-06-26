package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class WithdrawalListBean(
        @SerializedName("total") val total: Int,
        @SerializedName("pageSize") val pageSize: Int,
        @SerializedName("currentPage") val currentPage: Int,
        @SerializedName("rows") val rows: List<Row>
) {
    data class Row(
            @SerializedName("id") val id: Int,
            @SerializedName("description") val description: String,
            @SerializedName("payeeAddress") val payeeAddress: String,
            @SerializedName("payerAddress") val payerAddress: String,
            @SerializedName("gmtCreate") val gmtCreate: String,
            @SerializedName("state") val state: Int,
            @SerializedName("vpp") val vpp: Double,
            @SerializedName("cashNo") val cashNo: String
            )
}