package com.baotianqi.custom.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baotianqi.custom.utils.KLog;


/**
 * 作者：junj
 * 时间：2016/6/13
 * 描述：fragment的基类
 */
public abstract class BaseFragment extends Fragment {

    public  Context   mContext;
    private View     mView;
//    private Unbinder mUnbinder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        KLog.i("BaseFragment_onCreate");
        mContext = getActivity();
        _init();// 可以接受别人传递过来的参数
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        KLog.i("BaseFragment");
        if (mView == null) {
            mView = inflater.inflate(getLayoutId(), container, false);
        }
//        mUnbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        KLog.i("onActivityCreated");
        initData();
        initListener();
    }

    /**
     * 初始化的时候,可以接收别人传递进来的参数
     */
    public void _init() {

    }

    /**
     * 初始化Fragment应有的视图
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化Fragment应有的数据
     */
    public void initData() {

    }

    /**
     * 初始化监听器
     */
    public void initListener() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        mUnbinder.unbind();
    }
}
