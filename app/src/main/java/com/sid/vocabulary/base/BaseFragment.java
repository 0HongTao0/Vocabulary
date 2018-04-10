package com.sid.vocabulary.base;

import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 运用 Fragment 的懒加载模式统一管理 Fragment 的类
 * Created by HongTao on Created 2018/4/10
 *
 * @author HongTao
 */

public abstract class BaseFragment extends LazyFragment {

    private static final String TAG = BaseActivity.class.getSimpleName();
    private Unbinder mUnBinder;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(getContentViewId());
        mUnBinder = ButterKnife.bind(this, getContentView());
        init(savedInstanceState);
    }

    /**
     * 返回对应的 Layout ID
     *
     * @return
     */
    protected abstract int getContentViewId();

    /**
     * 在此初始化 Layout 对应的控件以及展示相应界面内容
     *
     * @param savedInstanceState
     */
    protected abstract void init(Bundle savedInstanceState);

    /**
     * Fragment 统一 Toast 方法
     *
     * @param msg
     */
    private void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        mUnBinder.unbind();
    }
}
