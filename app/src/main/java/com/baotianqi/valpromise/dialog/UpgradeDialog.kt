package com.baotianqi.valpromise.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import com.baotianqi.valpromise.R
import com.baotianqi.valpromise.dialog.interfaces.DialogClick2
import kotlinx.android.synthetic.main.dialog_upgrade.*


/**
 * 作者：junj
 * 时间：2016/11/25 11:40
 * 描述：更新
 */
class UpgradeDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    private var mContext: Context? = null
    private var mDialogClick2: DialogClick2? = null
    private var mTitle: String? = null
    private var mPush: Int? = null

    constructor(context: Context, title: String, push: Int, dialogClick2: DialogClick2) : this(context, R.style.MyDialogStyle) {
        mContext = context
        mDialogClick2 = dialogClick2
        mTitle = title
        mPush = push

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_upgrade)
        tv_title.text = mTitle
        if (mPush == 1) {
            ll_cancel.visibility = View.GONE
        } else {
            ll_cancel.visibility = View.VISIBLE
        }
        initListener()
    }

    private fun initListener() {
        tv_cancel.setOnClickListener {
            mDialogClick2?.dialogCancel()
            dismiss()
        }
        tv_affirm.setOnClickListener {
            mDialogClick2?.dialogOk()
            dismiss()
        }
    }



}
