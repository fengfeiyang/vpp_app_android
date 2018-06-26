package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class LoginBean(
    @SerializedName("token") val token: String,
    @SerializedName("payPasswordExist") val payPasswordExist: Int,
    @SerializedName("passwordExist") val passwordExist: Int
)