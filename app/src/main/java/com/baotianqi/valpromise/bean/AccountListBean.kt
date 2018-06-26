package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName

data class AccountListBean(
    @SerializedName("rows") val rows: List<AccountRow>
)