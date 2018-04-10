package com.sid.vocabulary.view.fragment;

import android.os.Bundle;

import com.sid.vocabulary.R;
import com.sid.vocabulary.base.BaseFragment;

/**
 * Created 2018/4/10.
 *
 * @author HongTao
 */

public class TranslationFragment extends BaseFragment {
    private static final String TAG = TranslationFragment.class.getSimpleName();

    public static TranslationFragment newInstance() {

        Bundle args = new Bundle();

        TranslationFragment fragment = new TranslationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_translation;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }
}
