package com.sid.vocabulary.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sid.vocabulary.R;
import com.sid.vocabulary.adapter.ExerciseRvAdapter;
import com.sid.vocabulary.api.ExerciseApi;
import com.sid.vocabulary.base.BaseFragment;
import com.sid.vocabulary.bean.Exercise;
import com.sid.vocabulary.bean.ExerciseDaoObject;
import com.sid.vocabulary.bean.ExerciseItem;
import com.sid.vocabulary.manager.ExerciseManager;
import com.sid.vocabulary.manager.SignManager;
import com.sid.vocabulary.manager.UserManager;
import com.sid.vocabulary.util.ExerciseUtil;
import com.sid.vocabulary.util.JSONUtil;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created 2018/4/10.
 *
 * @author HongTao
 */

public class ExerciseFragment extends BaseFragment {
    private static final String TAG = ExerciseFragment.class.getSimpleName();
    @BindView(R.id.exercise_tv_target)
    TextView mTvTarget;
    @BindView(R.id.exercise_rv_translation)
    RecyclerView mRvTranslation;
    @BindView(R.id.exercise_tv_num)
    TextView mTvNum;

    private static final int CAN_SIGN_CORRECT_NUM = 5;
    @BindView(R.id.exercise_tv_today_num)
    TextView mTvTodayNum;
    Unbinder unbinder;

    private long mDaoId;
    private int correctWord = -1;


    public static ExerciseFragment newInstance() {

        Bundle args = new Bundle();

        ExerciseFragment fragment = new ExerciseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_exercise;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        mDaoId = UserManager.getInstance().getDaoId();
        checkCanSign(new Date());
        if (null == ExerciseManager.getInstance().getExerciseDaoObject(mDaoId)) {
            getData();
        } else {
            Log.d(TAG, "init: mDaoId = " + mDaoId);
            ExerciseDaoObject exerciseDaoObject = ExerciseManager.getInstance().getExerciseDaoObject(mDaoId);
            updateView(ExerciseUtil.converseToExercise(exerciseDaoObject));
        }
    }

    private void getData() {
        Observable.create(new Observable.OnSubscribe<List<Exercise>>() {
            @Override
            public void call(Subscriber<? super List<Exercise>> subscriber) {
                String data = null;
                try {
                    data = ExerciseApi.getWordInEnglishApi(UserManager.getInstance().getUserId(), UserManager.getInstance().getWordNum());
                } catch (IOException e) {
                    subscriber.onNext(null);
                    e.printStackTrace();
                }
                Log.d(TAG, "call: " + data);
                Gson gson = new Gson();
                List<Exercise> exerciseList = gson.fromJson(JSONUtil.getString(data, "data", ""), new TypeToken<List<Exercise>>() {
                }.getType());
                subscriber.onNext(exerciseList);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Exercise>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Exercise> exercises) {
                        ExerciseManager.getInstance().insertExerciseDaoObjectList(ExerciseUtil.converseToExerciseDaoObject(exercises));
                        ExerciseDaoObject exerciseDaoObject = ExerciseManager.getInstance().getExerciseDaoObject(mDaoId);
                        updateView(ExerciseUtil.converseToExercise(exerciseDaoObject));
                    }
                });
    }

    private void updateView(final Exercise exercise) {
        mTvNum.setText("总练习:" + String.valueOf(mDaoId - 1));
        mTvTodayNum.setText("今天练习:" + correctWord);
        mTvTarget.setText(exercise.getWord());
        ExerciseRvAdapter exerciseRvAdapter = new ExerciseRvAdapter(ExerciseUtil.getExerciseItemList(exercise));
        mRvTranslation.setAdapter(exerciseRvAdapter);
        mRvTranslation.setLayoutManager(new LinearLayoutManager(getContext()) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        exerciseRvAdapter.setOnItemClickListener(new ExerciseRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ExerciseItem exerciseItem, boolean isCorrect) {
                Log.d(TAG, "onItemClick: " + exerciseItem.getTranslation() + isCorrect);
                if (isCorrect) {
                    ExerciseManager.getInstance().correctTheExerciseTimeInDB(exercise, mDaoId);
                    mDaoId++;
                    UserManager.getInstance().setDaoId(mDaoId);
                    ExerciseDaoObject exerciseDaoObject = ExerciseManager.getInstance().getExerciseDaoObject(mDaoId);
                    if (null == exerciseDaoObject) {
                        getData();
                    } else {
                        updateView(ExerciseUtil.converseToExercise(exerciseDaoObject));
                    }

                    if (checkCanSign(new Date())) {
                        SignManager.getInstance().insertSignDate(Calendar.getInstance(), true);
                    }
                }
            }
        });
    }

    private boolean checkCanSign(Date date) {
        if (correctWord == -1) {
            correctWord = ExerciseManager.getInstance().getExerciseDaoObjectsByDate(date).size();
        }else {
            correctWord++;
        }
        if (correctWord >= CAN_SIGN_CORRECT_NUM) {
            Log.d(TAG, "checkCanSign: today you can sign the WTE vocabulary.");
            return true;
        } else {
            Log.d(TAG, "checkCanSign: today you can't sign the WTE vocabulary, please exercise the words.");
            return false;
        }
    }
}
