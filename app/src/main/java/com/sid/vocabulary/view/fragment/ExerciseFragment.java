package com.sid.vocabulary.view.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.sid.vocabulary.R;
import com.sid.vocabulary.base.BaseFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created 2018/4/10.
 *
 * @author HongTao
 */

public class ExerciseFragment extends BaseFragment {
    private static final String TAG = ExerciseFragment.class.getSimpleName();
    @BindView(R.id.punch_tv_exercise)
    TextView punchTvExercise;
    Unbinder unbinder;

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
        punchTvExercise.setText("asdasdasd");
    }
}
