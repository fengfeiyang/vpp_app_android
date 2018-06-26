package com.baotianqi.valpromise.bean
import com.google.gson.annotations.SerializedName


/*
 *创建者：  hongjun
 *创建时间：2018/5/8 18:50
 *描述：   ${TODO}
 */


data class CustomerBalanceBean(
    @SerializedName("balance") val balance: Double,
    @SerializedName("isShow") val isShow: Int
)