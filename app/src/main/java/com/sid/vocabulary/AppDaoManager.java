package com.sid.vocabulary;

import android.util.Log;

import com.sid.vocabulary.dao.DaoMaster;
import com.sid.vocabulary.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by 随大大便 on 2017/8/25.
 */

public final class AppDaoManager {
    private static final String TAG = AppDaoManager.class.getSimpleName();
    private static final AppDaoManager instance = new AppDaoManager();
    private boolean isInit = false;
    private String dataBaseName;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private DaoMaster.OpenHelper openHelper;

    private AppDaoManager() {
    }

    public static AppDaoManager getInstance() {
        return instance;
    }

    public synchronized void init() {
        dataBaseName = UserManager.getInstance().getUserId();
        openHelper = new DaoMaster.OpenHelper(VocabularyApplication.getContext(), dataBaseName) {
            @Override
            public void onCreate(Database db) {
                super.onCreate(db);
                Log.d(TAG, dataBaseName + " onCreate");
            }
        };
        daoMaster = new DaoMaster(openHelper.getWritableDb());
        daoSession = daoMaster.newSession();
        isInit = true;
        Log.d(TAG, dataBaseName + " onInit");
    }

    public DaoSession getDaoSession() {
        if (!isInit) {
            Log.d(TAG, "You must init AppDaoManage first");
        }

        return daoSession;
    }
}
