package com.sid.vocabulary.manager;

import android.util.Log;

import com.sid.vocabulary.bean.Exercise;
import com.sid.vocabulary.bean.ExerciseDaoObject;
import com.sid.vocabulary.dao.ExerciseDaoObjectDao;
import com.sid.vocabulary.util.DateUtil;
import com.sid.vocabulary.util.ExerciseUtil;

import java.util.Date;
import java.util.List;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class ExerciseManager {
    private static final String TAG = ExerciseManager.class.getSimpleName();

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

    public List<ExerciseDaoObject> getExerciseDaoObjectsByDate(Date date) {
        String dateString = DateUtil.getFormatDateString(date);
        return mExerciseDaoObjectDao.queryBuilder()
                .where(ExerciseDaoObjectDao.Properties.CorrectDateString.eq(dateString))
                .list();
    }

    public void correctTheExerciseTimeInDB(Exercise exercise, long daoId) {
        Date date = new Date();
        ExerciseDaoObject exerciseDaoObject = ExerciseUtil.converseToExerciseDaoObject(exercise);
        exerciseDaoObject.setCorrectDateString(DateUtil.getFormatDateString(date));
        exerciseDaoObject.set_id(daoId);
        exerciseDaoObject.setCorrectDate(date);
        mExerciseDaoObjectDao.update(exerciseDaoObject);
        Log.d(TAG, "correctTheExerciseTimeInDB: daoId = " + exerciseDaoObject.get_id() + "  data = " + exerciseDaoObject.getCorrectDate() + "  dateString = " + exerciseDaoObject.getCorrectDateString());
    }
}
