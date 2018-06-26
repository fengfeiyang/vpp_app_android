package com.baotianqi.custom.base;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.baotianqi.custom.R;
import com.baotianqi.custom.bus.RxBus;
import com.baotianqi.custom.utils.SystemBarTintManager;
import com.baotianqi.custom.utils.UiUtils;
import com.baotianqi.custom.view.VpNavigationView;
import com.umeng.analytics.MobclickAgent;


/**
 * 作者：junj
 * 时间：2016/6/13
 * 描述：Activity的基类，在这里统一处理一些事物,继承自动适配的布局，可以直接用px布局了。
 */
public abstract class BaseActivity extends AppCompatActivity {

    //上下文
    public  Context     mContext;
    private Typeface    mTypeface;
    //    public  Unbinder    mUnbinder;
    private FrameLayout mFlContent;

    private VpNavigationView mNavView;
    private LinearLayout     mLl_base_view;


    /**
     * 统一初始化数据，但是在这里不绑定butterknife，插件会自动生成bind的语句
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        //设置字体
        initTypeface();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_base);
        mContext = this;
        initUi();
        _init();
        addContentView();

    }

    public abstract int getContentView ();

    private void initUi () {

        mNavView = findViewById(R.id.nav_bar_view);
        mLl_base_view = findViewById(R.id.ll_base_view);
        mFlContent = findViewById(R.id.fl_base_content);
    }


    protected void addContentView () {
        int resId = getContentView();
        if (resId != 0) {
            final View view = getLayoutInflater().inflate(resId, null);
//            mUnbinder = ButterKnife.bind(this, view);
            if (view != null && mFlContent != null) {
                final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                mFlContent.addView(view, layoutParams);
            }
        }
    }

    protected void setNavType (int type, String title) {
        if (mNavView != null) {
            mNavView.initBarUi(type, title);
        }
    }


    public void _init () {
        //设置状态栏的颜色
        String fingerprint = Build.FINGERPRINT.toLowerCase();
        if (!fingerprint.startsWith("xiaomi")) {
            setStatusBarColor(R.color.white);
        } else {
            setStatusBarColor(R.color.color_nav_bg);
        }
        mLl_base_view.setFitsSystemWindows(true);
    }


    /**
     * 设置字体
     */
    public void initTypeface () {
//        if (mTypeface == null) {
//            mTypeface = Typeface.createFromAsset(getAssets(), "shoujin.ttf");
//            LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
//                @Override
//                public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//                    AppCompatDelegate delegate = getDelegate();
//                    View view = delegate.createView(parent, name, context, attrs);
//                    if (view != null && (view instanceof TextView)) {
//                        ((TextView) view).setTypeface(mTypeface);
//                    }
//                    if (view != null && (view instanceof EditText)) {
//                        ((EditText) view).setTypeface(mTypeface);
//                    }
//                    return view;
//                }
//            });
//        }
    }

    /**
     * 设置状态栏颜色
     * 也就是所谓沉浸式状态栏
     */
    public void setStatusBarColor (int color) {
        /**
         * Android4.4以上  但是抽屉有点冲突，目前就重写一个方法暂时解决4.4的问题
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(color);
        }
    }


    public void setBlueAcountTitle () {
        if (mNavView != null) {
            mNavView.setBlueBg();
            UiUtils.setActivityBarTransucent(this, R.color.color_bule);
        }
    }

    public void setShowTradeTitle () {
        if (mNavView != null) {
            mNavView.setNavBg();
            UiUtils.setActivityBarTransucent(this, R.color.color_nav_bg);
        }
    }

    public void setBlueBgRightBtn (VpNavigationView.CallBack callBack) {
        if (mNavView != null) {
            mNavView.setBlueBgRightBtn(callBack);
        }
    }


    @Override
    protected void onDestroy () {
//        if (mUnbinder != null) {
//            mUnbinder.unbind();
//        }
        RxBus.getInstance().unSubscribe(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


}
