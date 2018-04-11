package com.sid.vocabulary;

import com.sid.vocabulary.bean.ExerciseDaoObject;
import com.sid.vocabulary.dao.ExerciseDaoObjectDao;

import java.util.List;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class ExerciseManager {
    private static ExerciseManager mExerciseManager;
    private ExerciseDaoObjectDao mExerciseDaoObjectDao;

    private ExerciseManager() {
        mExerciseDaoObjectDao = AppDaoManager.getInstance().getDaoSession().getExerciseDaoObjectDao();
    }

    public static ExerciseManager getInstance() {
        if (mExerciseManager == null) {
            synchronized (ExerciseManager.class) {
                if (mExerciseManager == null) {
                    mExerciseManager = new ExerciseManager();
                }
            }
        }
        return mExerciseManager;
    }

    public void insertExerciseDaoObjectList(List<ExerciseDaoObject> list) {
        for (int i = 0; i < list.size(); i++) {
            mExerciseDaoObjectDao.insertOrReplace(list.get(i));
        }
    }

    public ExerciseDaoObject getExerciseDaoObject(long id) {
        return mExerciseDaoObjectDao.loadByRowId(id);
    }
}
