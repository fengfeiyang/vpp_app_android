package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName


data class HomeBean(
    @SerializedName("notices") val notices: List<Notice>,
    @SerializedName("rainOrders") val rainOrders: List<RainOrder>,
    @SerializedName("tempOrders") val tempOrders: List<TempOrder>,
    @SerializedName("coinguessOrders") val coinguessOrders: List<TempOrder>,
    @SerializedName("banners") val banners: List<Banner>
) {
    data class RainOrder(
        @SerializedName("innerOrderId") val innerOrderId: String,
        @SerializedName("title") val title: String,
        @SerializedName("gmtCreate") val gmtCreate: String,
        @SerializedName("content") val content: String,
        @SerializedName("amount") val amount: String,
        @SerializedName("status") val status: String
    )

    data class Banner(
        @SerializedName("imgUrl") val imgUrl: String,
        @SerializedName("linkUrl") val linkUrl: String
    )

    data class Notice(
        @SerializedName("id") val id: Int,
        @SerializedName("gmtCreate") val gmtCreate: String,
        @SerializedName("gmtModified") val gmtModified: String,
        @SerializedName("description") val description: Any,
        @SerializedName("creater") val creater: Any,
        @SerializedName("mender") val mender: Int,
        @SerializedName("noticeTitle") val noticeTitle: String,
        @SerializedName("noticeContent") val noticeContent: String,
        @SerializedName("noticeState") val noticeState: Int
    )

    data class TempOrder(
        @SerializedName("innerOrderId") val innerOrderId: String,
        @SerializedName("title") val title: String,
        @SerializedName("gmtCreate") val gmtCreate: String,
        @SerializedName("content") val content: String,
        @SerializedName("amount") val amount: String,
        @SerializedName("status") val status: String
    )
}