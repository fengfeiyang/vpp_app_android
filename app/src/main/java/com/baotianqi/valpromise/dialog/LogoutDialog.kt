package com.baotianqi.valpromise.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.baotianqi.valpromise.R
import com.baotianqi.valpromise.dialog.interfaces.DialogClick2
import kotlinx.android.synthetic.main.dialog_upgrade.*


/**
 * 作者：junj
 * 时间：2016/11/25 11:40
 * 描述：更新
 */
class LogoutDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    private var mContext: Context? = null
    private var mDialogClick2: DialogClick2? = null

    constructor(context: Context,dialogClick2: DialogClick2) : this(context, R.style.MyDialogStyle) {
        mContext = context
        mDialogClick2 = dialogClick2

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_logout)
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
