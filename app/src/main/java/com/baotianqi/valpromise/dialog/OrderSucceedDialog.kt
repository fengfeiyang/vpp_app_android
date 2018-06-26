package com.baotianqi.valpromise.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.baotianqi.valpromise.R
import kotlinx.android.synthetic.main.dialog_order_succeed.*
import java.text.DecimalFormat


/**
 * 作者：junj
 * 时间：2016/11/25 11:40
 * 描述：更新
 */
class OrderSucceedDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    private var mContext: Context? = null
    private var content: String? = null
    private var mAmount: Double? = null

    constructor(context: Context, amount: Double, tips: String) : this(context, R.style.DefaultDialogStyle) {
        mContext = context
        content = tips
        mAmount = amount


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_order_succeed)
        tv_content.text = content
        tv_pay_vpp.text = "共支付 ${DecimalFormat(".00").format(mAmount)} VPP"
        btn_back?.setOnClickListener {
            dismiss()
        }
    }

}
