package com.sid.vocabulary.view.fragment;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;

import com.sid.vocabulary.R;
import com.sid.vocabulary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.aigestudio.datepicker.bizs.calendars.DPCManager;
import cn.aigestudio.datepicker.bizs.decors.DPDecor;
import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;

/**
 * Created 2018/4/10.
 *
 * @author HongTao
 */

public class PunchFragment extends BaseFragment {
    private static final String TAG = PunchFragment.class.getSimpleName();
    @BindView(R.id.punch_dp_calender)
    DatePicker mDpCalender;

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
        initPunchCalender();
    }

    private void initPunchCalender() {
        mDpCalender.setDate(2018, 4);
        List<String> tmp = new ArrayList<>();
        tmp.add("2018-4-1");
        tmp.add("2018-4-8");
        tmp.add("2018-4-16");
        DPCManager.getInstance().setDecorBG(tmp);
        mDpCalender.setMode(DPMode.NONE);
        mDpCalender.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint) {
                paint.setColor(Color.GREEN);
                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
            }
        });
    }
}
