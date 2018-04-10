package com.sid.vocabulary.view.fragment;

import android.os.Bundle;

import com.sid.vocabulary.R;
import com.sid.vocabulary.base.BaseFragment;

/**
 * Created 2018/4/10.
 *
 * @author HongTao
 */

public class PunchFragment extends BaseFragment {
    private static final String TAG = PunchFragment.class.getSimpleName();

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

    }
}
