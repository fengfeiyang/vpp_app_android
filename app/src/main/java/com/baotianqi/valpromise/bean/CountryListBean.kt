package com.baotianqi.valpromise.bean

import com.baotianqi.valpromise.view.sortlistview.SortModel
import com.google.gson.annotations.SerializedName


data class CountryListBean(
    @SerializedName("total") val total: Int,
    @SerializedName("pageSize") val pageSize: Int,
    @SerializedName("currentPage") val currentPage: Int,
    @SerializedName("rows") val rows: List<SortModel>
)