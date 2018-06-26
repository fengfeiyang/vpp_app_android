package com.baotianqi.valpromise.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.baotianqi.custom.base.BaseFragment;

import java.util.List;


/**
 * Created by kuanglingbo on 2018/3/18.
 */

public class AccountItemsAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments;

    public AccountItemsAdapter (FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        mFragments = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
