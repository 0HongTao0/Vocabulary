package com.sid.vocabulary.common;

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

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 得到 App 的 Context（全局通用）
     * @return
     */
    public static Context getAppContext(){
        return getAppContext();
    }
}
