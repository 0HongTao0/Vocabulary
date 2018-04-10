package com.sid.vocabulary.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by HongTao on Created 2018/4/10
 *
 * @author HongTao
 */

public class CommonViewPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = CommonViewPagerAdapter.class.getSimpleName();

    private List<Fragment> mFragmentList;

    public CommonViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return null == mFragmentList ? 0 : mFragmentList.size();
    }
}
