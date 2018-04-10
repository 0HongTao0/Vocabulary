package com.sid.vocabulary.common;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by HongTao on Created 2018/4/10
 *
 * @author HongTao
 */

public class CommonTabBean implements CustomTabEntity {
    private int selectedIcon;
    private int unselectedIcon;
    private String title;

    public CommonTabBean(String title, int selectedIcon, int unselectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unselectedIcon = unselectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselectedIcon;
    }
}
