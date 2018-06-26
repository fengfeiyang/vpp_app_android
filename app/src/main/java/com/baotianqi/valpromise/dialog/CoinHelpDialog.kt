package com.baotianqi.valpromise.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.baotianqi.valpromise.R
import kotlinx.android.synthetic.main.dialog_coin_help.*


/**
 * 作者：junj
 * 时间：2016/11/25 11:40
 * 描述：更新
 */
class CoinHelpDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    private var mContext: Context? = null
    private var mText: String? = null

    constructor(context: Context, text: String) : this(context, R.style.MyDialogStyle) {
        mContext = context
        mText = text

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_coin_help)
        tv_content.text = mText
        initListener()
    }

    private fun initListener() {
        tv_cancel.setOnClickListener {
            dismiss()
        }
    }


}
