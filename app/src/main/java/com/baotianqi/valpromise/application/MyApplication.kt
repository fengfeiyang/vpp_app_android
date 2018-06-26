package com.baotianqi.valpromise.application

import com.baotianqi.custom.base.BaseApplication
import com.baotianqi.custom.utils.SPUtils
import com.baotianqi.valpromise.constant.Constants
import com.example.http.HttpUtils
import com.squareup.leakcanary.LeakCanary
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure

/*
 *创建者：  hongjun
 *创建时间：2018/4/27 11:11
 *描述：   ${TODO}
 */
class MyApplication : BaseApplication() {
    companion object {
        @JvmField
        var BASE_URL: String = ""
        @JvmField
        var token: String = ""
        @JvmField
        var isSetPayPwd: Boolean = false

        @JvmField
        var isSetLoginPwd: Boolean = false
        @JvmField
        var mWxapi: IWXAPI? = null
    }

    override fun onCreate() {
        super.onCreate()
        token = SPUtils.getInstance().getString(Constants.TOKEN)
        if (Constants.DEBUG) BASE_URL = Constants.DEBUG_URL else BASE_URL = Constants.RELEASE_URL

        isSetPayPwd = SPUtils.getInstance().getInt(Constants.ISSETPAYPWD) == 1
        isSetLoginPwd = SPUtils.getInstance().getInt(Constants.ISSETLOGINPWD) == 1

        if (LeakCanary.isInAnalyzerProcess(this)) return
        LeakCanary.install(this)

        HttpUtils.getInstance().init(this, Constants.DEBUG)
        registToWX()
        //友盟统计初始化
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, null)
        if (Constants.DEBUG){
            MobclickAgent.setCatchUncaughtExceptions(false)
        }
    }


    private fun registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        mWxapi = WXAPIFactory.createWXAPI(this, Constants.WEIXIN.APP_ID, true)
        // 将该app注册到微信
        mWxapi?.registerApp(Constants.WEIXIN.APP_ID)
    }
}