package com.baotianqi.valpromise.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.baotianqi.valpromise.R
import kotlinx.android.synthetic.main.dialog_decide_reslut.*


/**
 * 作者：junj
 * 时间：2016/11/25 11:40
 * 描述：更新
 */
class DecideReslutDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    private var mContext: Context? = null
    private var mTitle: String? = null

    constructor(context: Context, title: String) : this(context, R.style.MyDialogStyle) {
        mContext = context
        mTitle = title

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_decide_reslut)
        tv_title.text = mTitle
        initListener()
    }

    private fun initListener() {
        tv_cancel.setOnClickListener {
            dismiss()
        }
    }



}
