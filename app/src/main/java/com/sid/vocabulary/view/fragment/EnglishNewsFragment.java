package com.sid.vocabulary.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sid.vocabulary.R;
import com.sid.vocabulary.adapter.EnglishNewsAdapter;
import com.sid.vocabulary.api.VocabularyApi;
import com.sid.vocabulary.base.BaseFragment;
import com.sid.vocabulary.bean.EnglishNews;
import com.sid.vocabulary.util.JSONUtil;
import com.sid.vocabulary.view.activity.EnglishNewsActivity;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created 2018/4/10.
 *
 * @author HongTao
 */

public class EnglishNewsFragment extends BaseFragment {
    private static final String TAG = EnglishNewsFragment.class.getSimpleName();
    @BindView(R.id.english_news_rv_list)
    RecyclerView mRvList;

    public static EnglishNewsFragment newInstance() {

        Bundle args = new Bundle();

        EnglishNewsFragment fragment = new EnglishNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_english_news;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        getData();
    }

    private void getData() {
        Observable.create(new Observable.OnSubscribe<List<EnglishNews>>() {
            @Override
            public void call(Subscriber<? super List<EnglishNews>> subscriber) {
                try {
                    String response = VocabularyApi.getEnglishNewApi();
                    String data = JSONUtil.getJSONArray(response, "articles", null).toString();
                    Gson gson = new Gson();
                    List<EnglishNews> englishNews = gson.fromJson(data, new TypeToken<List<EnglishNews>>() {
                    }.getType());
                    subscriber.onNext(englishNews);
                } catch (IOException e) {
                    showToast("网络错误");
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<EnglishNews>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        showToast("网络错误");
                    }

                    @Override
                    public void onNext(List<EnglishNews> englishNews) {
                        EnglishNewsAdapter englishNewsAdapter = new EnglishNewsAdapter(englishNews);
                        englishNewsAdapter.setOnItemClickListener(new EnglishNewsAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(EnglishNews englishNews) {
                                Log.d(TAG, "onItemClick: ");
                                EnglishNewsActivity.startActivity(englishNews.getUrl(), getContext());
                            }
                        });
                        mRvList.setAdapter(englishNewsAdapter);
                        mRvList.setLayoutManager(new LinearLayoutManager(getContext()));
                    }
                });

    }
}
