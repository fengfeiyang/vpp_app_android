package com.baotianqi.valpromise

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.view.KeyEvent
import android.view.View
import com.baotianqi.custom.base.BaseActivity
import com.baotianqi.custom.utils.ToastUtils
import com.baotianqi.custom.view.VpNavigationView
import com.baotianqi.valpromise.ui.fragment.AccountFragment
import com.baotianqi.valpromise.ui.fragment.HomeFragment
import com.baotianqi.valpromise.ui.fragment.TradeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_bottom_layout_view.*


class MainActivity : BaseActivity(), View.OnClickListener {

    var currIndex = -1
    val TAB_INDEX_HOME = 0
    val TAB_INDEX_TRADE = 1
    val TAB_INDEX_ACCOUNT = 2
    val HOMETAG = "HomeFragmentTag"
    val TRADETAG = "TradeFragmentTag"
    val ACCOUNTTAG = "AccountFragmentTag"
    var mExitTime: Long = 0
    var homeFragment: HomeFragment? = null
    var tradeFragment: TradeFragment? = null
    var accountFragment: AccountFragment? = null

    companion object {
        fun startMainActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setNavType(VpNavigationView.NAV_TYPE_HINT, "")
        initListener()
        selectTab(TAB_INDEX_HOME)
    }

    private fun initListener() {
        ll_tab_home.setOnClickListener(this)
        ll_tab_trade.setOnClickListener(this)
        ll_tab_account.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v) {
            ll_tab_home -> {
                selectTab(TAB_INDEX_HOME)
            }
            ll_tab_trade -> {
                selectTab(TAB_INDEX_TRADE)
            }
            ll_tab_account -> {
                selectTab(TAB_INDEX_ACCOUNT)
            }
        }
    }


    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun _init() {
        setStatusBarColor(R.color.tran)
    }

    fun selectTradeView(page: Int) {
        val findFragmentByTag = supportFragmentManager.findFragmentByTag(TRADETAG)
        if (findFragmentByTag != null) {
            selectTab(TAB_INDEX_TRADE)
            (findFragmentByTag as TradeFragment).selectTab(page)
        } else {
            selectTab(TAB_INDEX_TRADE, page)
        }
    }

    fun selectTab(index: Int) {
        selectTab(index, 0)
    }

    fun selectTab(index: Int, selectPage: Int) {
        if (index == currIndex) return

        currIndex = index

        val transaction = supportFragmentManager.beginTransaction()

        hideFragment(transaction)

        when (index) {
            TAB_INDEX_HOME -> {
                showTab(index)
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                    transaction.add(R.id.fl_main_content, homeFragment, HOMETAG)
                } else {
                    homeFragment!!.loadData()
                }
                transaction.show(homeFragment)
            }
            TAB_INDEX_TRADE -> {
                showTab(index)
                if (tradeFragment == null) {
                    tradeFragment = TradeFragment(selectPage)
                    transaction.add(R.id.fl_main_content, tradeFragment, TRADETAG)
                } else {
                    tradeFragment!!.loadData()
                }
                transaction.show(tradeFragment)
            }
            TAB_INDEX_ACCOUNT -> {
                showTab(index)
                if (accountFragment == null) {
                    accountFragment = AccountFragment()
                    transaction.add(R.id.fl_main_content, accountFragment, ACCOUNTTAG)
                } else {
                    accountFragment!!.loadData()
                }
                transaction.show(accountFragment)
            }
        }
        transaction.commit()

    }

    private fun showTab(index: Int) {
        restTab()
        when (index) {
            TAB_INDEX_HOME -> {
                img_tab_home.setImageResource(R.drawable.icon_home)
                tv_tab_home.setTextColor(ContextCompat.getColor(this, R.color.tv_blue))
            }
            TAB_INDEX_TRADE -> {
                img_tab_trade.setImageResource(R.drawable.icon_bourse)
                tv_tab_trade.setTextColor(ContextCompat.getColor(this, R.color.tv_blue))
            }
            TAB_INDEX_ACCOUNT -> {
                img_tab_account.setImageResource(R.drawable.icon_user)
                tv_tab_account.setTextColor(ContextCompat.getColor(this, R.color.tv_blue))
            }
        }
    }

    private fun restTab() {
        img_tab_home.setImageResource(R.drawable.icon_home_defaut)
        tv_tab_home.setTextColor(ContextCompat.getColor(this, R.color.tv_gray))
        img_tab_trade.setImageResource(R.drawable.icon_bourse_defaut)
        tv_tab_trade.setTextColor(ContextCompat.getColor(this, R.color.tv_gray))
        img_tab_account.setImageResource(R.drawable.icon_user_defaut)
        tv_tab_account.setTextColor(ContextCompat.getColor(this, R.color.tv_gray))
    }

    private fun hideFragment(transaction: FragmentTransaction?) {
        if (homeFragment != null) transaction?.hide(homeFragment)
        if (tradeFragment != null) transaction?.hide(tradeFragment)
        if (accountFragment != null) transaction?.hide(accountFragment)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit()
            return false
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            ToastUtils.showShort(getString(R.string.str_exit))
            mExitTime = System.currentTimeMillis()
        } else {
            finish()
            System.exit(0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fl_main_content?.removeAllViews()
        homeFragment = null
        tradeFragment = null
        accountFragment = null
    }


}

