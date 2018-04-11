package com.sid.vocabulary;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class UserManager {
    private static final String SP_USER = "sp_user";
    private static final String USER_ID = "user_id";
    private static final String WORD_NUM = "word_num";
    private static final String DAO_ID = "dao_id";

    private String userId;
    private int wordNum;
    private SharedPreferences sp;
    private long daoId;

    private static UserManager mUserManager;

    private UserManager() {
        sp = VocabularyApplication.getContext().getSharedPreferences(SP_USER, Context.MODE_PRIVATE);
        userId = null;
        wordNum = -1;
        daoId = -1;
    }

    public static UserManager getInstance() {
        if (mUserManager == null) {
            synchronized (UserManager.class) {
                if (mUserManager == null) {
                    mUserManager = new UserManager();
                }
            }
        }
        return mUserManager;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        sp.edit().putString(USER_ID, userId).apply();
    }

    public String getUserId() {
        if (userId == null || userId.length() == 0) {
            userId = sp.getString(USER_ID, "");
        }
        return userId;
    }

    public void setWordNum(int wordNum) {
        this.wordNum = wordNum;
        sp.edit().putInt(WORD_NUM, wordNum).apply();
    }

    public int getWordNum() {
        if (wordNum < 0) {
            wordNum = sp.getInt(WORD_NUM, -1);
        }
        return wordNum;
    }

    public void setDaoId(int daoId) {
        this.wordNum = daoId;
        sp.edit().putInt(DAO_ID, daoId).apply();
    }

    public long getDaoId() {
        if (daoId < 0) {
            daoId = sp.getInt(DAO_ID, -1);
        }
        return daoId;
    }
}
