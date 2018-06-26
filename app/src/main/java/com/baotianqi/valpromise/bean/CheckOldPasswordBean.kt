package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class CheckOldPasswordBean(
    @SerializedName("oldPayPassword") val oldPayPassword: String
)