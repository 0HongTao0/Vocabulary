package com.sid.vocabulary.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sid.vocabulary.ExerciseManager;
import com.sid.vocabulary.R;
import com.sid.vocabulary.UserManager;
import com.sid.vocabulary.adapter.ExerciseRvAdapter;
import com.sid.vocabulary.api.ExerciseApi;
import com.sid.vocabulary.base.BaseFragment;
import com.sid.vocabulary.bean.Exercise;
import com.sid.vocabulary.bean.ExerciseItem;
import com.sid.vocabulary.util.ExerciseUtil;
import com.sid.vocabulary.util.JSONUtil;

import java.util.ArrayList;
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
    Unbinder unbinder;

    private List<Exercise> mExerciseList = new ArrayList<>();

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
        initData();
    }

    private void initData() {
        Observable.create(new Observable.OnSubscribe<List<Exercise>>() {
            @Override
            public void call(Subscriber<? super List<Exercise>> subscriber) {
                String data = ExerciseApi.getWordInEnglishApi(UserManager.getInstance().getUserId(), UserManager.getInstance().getWordNum());
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
                        Log.d(TAG, "onNext: " + ExerciseManager.getInstance().getExerciseDaoObject(1).getWord());
//                        ExerciseManager.getInstance().insertExerciseDaoObjectList();
//                        mExerciseList.addAll(exercises);
//                        mTvTarget.setText(exercises.get(0).getWord());
//                        updateView(ExerciseUtil.getExerciseItemList(exercises.get(0)));
                    }
                });
    }

    private void updateView(List<ExerciseItem> exerciseItemList) {
        ExerciseRvAdapter exerciseRvAdapter = new ExerciseRvAdapter(exerciseItemList);
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
            }
        });
    }
}
