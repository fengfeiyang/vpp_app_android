package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class DepositInfoBean(
    @SerializedName("total") val total: Int,
    @SerializedName("pageSize") val pageSize: Int,
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("rows") val rows: List<Row>
) {
    data class Row(
        @SerializedName("id") val id: Int,
        @SerializedName("vpp") val vpp: Double,
        @SerializedName("timastamp") val timastamp: Long,
        @SerializedName("payer_address") val payerAddress: String
    )
}