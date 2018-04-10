package com.sid.vocabulary.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.sid.vocabulary.R;
import com.sid.vocabulary.base.BaseActivity;
import com.sid.vocabulary.common.CommonTabBean;
import com.sid.vocabulary.common.CommonViewPagerAdapter;
import com.sid.vocabulary.view.fragment.ExerciseFragment;
import com.sid.vocabulary.view.fragment.PunchFragment;
import com.sid.vocabulary.view.fragment.TranslationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by HongTao on 2017/10/29.
 *
 * @author HongTao
 */
public class HomeActivity extends BaseActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();
    @BindView(R.id.home_view_pager)
    ViewPager mHomeViewPager;
    @BindView(R.id.home_tab_layout)
    CommonTabLayout mHomeTabLayout;


    private List<Fragment> mFragmentList;

    private static final int[] SELECTED_ICON = {R.drawable.selected_translate, R.drawable.selected_exercise, R.drawable.selected_punch};
    private static final int[] UN_SELECTED_ICON = {R.drawable.unselected_translate, R.drawable.unselected_exercise, R.drawable.unselected_punch};
    private static final String[] TITLES = new String[]{"翻译", "练习", "打卡"};

    @Override
    protected int getContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initFragmentList();
        initViewPager();
        initTabLayout();
    }

    private void initTabLayout() {
        ArrayList<CustomTabEntity> customTabEntities = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            customTabEntities.add(new CommonTabBean(TITLES[i], SELECTED_ICON[i], UN_SELECTED_ICON[i]));
        }
        mHomeTabLayout.setTabData(customTabEntities);
        mHomeTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mHomeViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mHomeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mHomeTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mHomeViewPager.setOffscreenPageLimit(2);
        mHomeViewPager.setCurrentItem(1);
    }

    private void initFragmentList() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(TranslationFragment.newInstance());
        mFragmentList.add(ExerciseFragment.newInstance());
        mFragmentList.add(PunchFragment.newInstance());
    }

    private void initViewPager() {
        CommonViewPagerAdapter commonViewPagerAdapter = new CommonViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mHomeViewPager.setAdapter(commonViewPagerAdapter);
    }
}
