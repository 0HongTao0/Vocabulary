package com.sid.vocabulary;

import android.app.Application;
import android.content.Context;

/**
 * App 唯一一个 Application
 * <p>
 * Created by HongTao on Created 2018/4/10
 *
 * @author HongTao
 */

public final class VocabularyApplication extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        UserManager.getInstance().setUserId("666666");
        AppDaoManager.getInstance().init();
    }

    /**
     * 得到 App 的 Context（全局通用）
     * @return
     */
    public static Context getContext(){
        return sContext;
    }
}
