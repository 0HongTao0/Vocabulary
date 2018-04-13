package com.sid.vocabulary.view.fragment;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sid.vocabulary.R;
import com.sid.vocabulary.base.BaseFragment;
import com.sid.vocabulary.bean.SignDate;
import com.sid.vocabulary.manager.SignManager;
import com.sid.vocabulary.signview.SignAdapter;
import com.sid.vocabulary.signview.SignEntity;
import com.sid.vocabulary.signview.SignView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created 2018/4/10.
 *
 * @author HongTao
 */

public class PunchFragment extends BaseFragment {
    private static final String TAG = PunchFragment.class.getSimpleName();
    @BindView(R.id.punch_tv_main_day)
    TextView mTvMainDay;
    @BindView(R.id.punch_tv_day_sum)
    TextView mTvDaySum;
    @BindView(R.id.punch_tv_year)
    TextView mTvYear;
    @BindView(R.id.punch_tv_month)
    TextView mTvMonth;
    @BindView(R.id.punch_btn_sign)
    Button mBtnSign;
    @BindView(R.id.punch_ll_date)
    LinearLayout mLlDate;
    @BindView(R.id.punch_cv_calendar)
    SignView mCvCalendar;
    Unbinder unbinder;


    private List<SignEntity> data;


    public static PunchFragment newInstance() {

        Bundle args = new Bundle();

        PunchFragment fragment = new PunchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_punch;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        onReady();
    }

    private void onReady() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonthToday = calendar.get(Calendar.DAY_OF_MONTH);

        List<SignDate> signDates = SignManager.getInstance().getSignDate(year, month);

        mTvMainDay.setText(Html.fromHtml(getString(R.string.you_have_sign)));
        mTvDaySum.setText(String.valueOf(signDates.size()));
        mTvYear.setText(String.valueOf(year));
        mTvMonth.setText(getResources().getStringArray(R.array.month_array)[month]);

        data = new ArrayList<>();
        for (int i = 1; i <= dayOfMonthToday; i++) {
            SignEntity signEntity = new SignEntity();
            if (i == dayOfMonthToday) {
                signEntity.setDayType(2);
            }else {
                signEntity.setDayType(1);
            }
            for (int j = 0; j < signDates.size(); j++) {
                if (signDates.get(j).getDay() == i) {
                    signEntity.setDayType(0);
                    break;
                } else if (dayOfMonthToday == i) {
                    signEntity.setDayType(2);
                } else {
                    signEntity.setDayType(1);
                }
            }
            data.add(signEntity);
        }
        SignAdapter signAdapter = new SignAdapter(data);
        mCvCalendar.setAdapter(signAdapter);
    }

    @OnClick(R.id.punch_btn_sign)
    public void onViewClicked() {
        onReady();
        Log.d(TAG, "onClick: refresh the sign sum and calender");
    }

}
