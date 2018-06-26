package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName


data class BannerBean(
    @SerializedName("notices") val notices: List<Notice>,
    @SerializedName("banners") val banners: List<Banner>
)

data class Banner(
    @SerializedName("imgUrl") val imgUrl: String,
    @SerializedName("linkUrl") val linkUrl: String
)

data class Notice(
    @SerializedName("content") val content: String
)