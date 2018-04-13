package com.sid.vocabulary;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.sid.vocabulary.manager.AppDaoManager;
import com.sid.vocabulary.manager.UserManager;
import com.sid.vocabulary.signview.ResolutionUtil;

import okhttp3.OkHttpClient;

/**
 * App 唯一一个 Application
 * <p>
 * Created by HongTao on Created 2018/4/10
 *
 * @author HongTao
 */

public final class VocabularyApplication extends Application {
    private static final String TAG = VocabularyApplication.class.getSimpleName();
    private static OkHttpClient sOkHttpClient;
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        ResolutionUtil.getInstance().init(this);
        sContext = getApplicationContext();
        sOkHttpClient = new OkHttpClient();
        loginVocabulary();
        AppDaoManager.getInstance().init();
    }

    /**
     * 得到 App 的 Context（全局通用）
     *
     * @return
     */
    public static Context getContext() {
        return sContext;
    }

    public static OkHttpClient getOkHttpClient() {
        return sOkHttpClient;
    }

    private void loginVocabulary() {
        String userId = UserManager.getInstance().getUserId().equals("") ? String.valueOf((int) ((Math.random() * 9 + 1) * 100000)) : UserManager.getInstance().getUserId();
        int wordNum = UserManager.getInstance().getWordNum() == -1 ? 50 : UserManager.getInstance().getWordNum();
        long daoId = UserManager.getInstance().getDaoId() == -1 ? 1 : UserManager.getInstance().getDaoId();
        UserManager.getInstance().onUserLogin(userId, wordNum, daoId);
        Log.d(TAG, "loginVocabulary: wordNum = " + UserManager.getInstance().getWordNum());
        Log.d(TAG, "loginVocabulary: userId = " + UserManager.getInstance().getUserId());
    }
}
