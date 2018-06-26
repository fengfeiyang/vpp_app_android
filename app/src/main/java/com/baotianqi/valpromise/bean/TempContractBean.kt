package com.baotianqi.valpromise.bean

import com.google.gson.annotations.SerializedName


data class TempContractBean(
        @SerializedName("contractList") val contractList: List<Contract>,
        @SerializedName("contractTitle") val contractTitle: String,
        @SerializedName("contractId") val contractId: String,
        @SerializedName("maxBuyCount") val maxBuyCount: Int,
        @SerializedName("explainFirst") val explainFirst: String,
        @SerializedName("explainSecond") val explainSecond: String
) {
    data class Contract(
            @SerializedName("title") val title: String,
            @SerializedName("strike") val strike: String,
            @SerializedName("price") val price: String,
            @SerializedName("payoff") val payoff: String,
            @SerializedName("condition") val condition: String,
            @SerializedName("validity") val validity: String
    )
}