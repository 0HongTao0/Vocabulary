package com.sid.vocabulary.manager;

import android.util.Log;

import com.sid.vocabulary.bean.SignDate;
import com.sid.vocabulary.dao.SignDateDao;

import java.util.Calendar;
import java.util.List;

/**
 * Created 2018/4/13.
 *
 * @author HongTao
 */

public class SignManager {
    private static final String TAG = SignManager.class.getSimpleName();
    private static SignManager mSignManager;
    private SignDateDao mSignDateDao;

    private SignManager() {
        mSignDateDao = AppDaoManager.getInstance().getDaoSession().getSignDateDao();
    }

    public static SignManager getInstance() {
        if (mSignManager == null) {
            synchronized (ExerciseManager.class) {
                if (mSignManager == null) {
                    mSignManager = new SignManager();
                }
            }
        }
        return mSignManager;
    }

    public void insertSignDate(Calendar calendar, boolean isSign) {
        SignDate signDate = new SignDate();
        signDate.setDay(calendar.get(Calendar.DATE));
        signDate.setMonth(calendar.get(Calendar.MONTH));
        signDate.setYear(calendar.get(Calendar.YEAR));
        signDate.setSign(isSign);
        mSignDateDao.insertOrReplace(signDate);
        Log.d(TAG, "insertSignDate: " + calendar.get(Calendar.YEAR) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.DATE) + "   have sign");
    }

    public List<SignDate> getSignDate(int year, int month) {
        return mSignDateDao.queryBuilder()
                .where(SignDateDao.Properties.Year.eq(year), SignDateDao.Properties.Month.eq(month))
                .list();
    }

    public boolean isDateSign(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        List<SignDate> signDates = mSignDateDao.queryBuilder().
                where(SignDateDao.Properties.Year.eq(year), SignDateDao.Properties.Month.eq(month), SignDateDao.Properties.Day.eq(date)).list();
        return signDates.size() != 0;
    }

}
