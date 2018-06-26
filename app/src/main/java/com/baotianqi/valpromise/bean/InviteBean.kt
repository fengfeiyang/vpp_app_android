package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName


data class InviteBean(
    @SerializedName("shareTitle") val shareTitle: String,
    @SerializedName("inviteCode") val inviteCode: String,
    @SerializedName("shareUrl") val shareUrl: String,
    @SerializedName("qrCode") val qrCode: String,
    @SerializedName("shareIcon") val shareIcon: String,
    @SerializedName("shareContent") val shareContent: String,
    @SerializedName("noUseInviteCode") val noUseInviteCode: Int,
    @SerializedName("inviteUp") val inviteUp: Int
)