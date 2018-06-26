package com.baotianqi.valpromise.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Html
import android.view.WindowManager
import com.baotianqi.valpromise.R
import com.baotianqi.valpromise.dialog.interfaces.DialogClick
import kotlinx.android.synthetic.main.dialog_home_tips.*


/**
 * 作者：junj
 * 时间：2016/11/25 11:40
 * 描述：更新
 */
class HomeTipsDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    private var mContext: Context? = null
    private var mDialogClick: DialogClick? = null
    private val content: String = "在这里，你有你的金融自由！"

    constructor(context: Context, dialogClick: DialogClick) : this(context, R.style.DefaultDialogStyle) {
        mContext = context
        mDialogClick = dialogClick

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_home_tips)
        tv_content?.text = Html.fromHtml(content)
        btn_affirm?.setOnClickListener {
            mDialogClick?.dialogCancel()
            dismiss()
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
    }

}
