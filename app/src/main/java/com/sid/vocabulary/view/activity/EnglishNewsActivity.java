package com.sid.vocabulary.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.sid.vocabulary.R;
import com.sid.vocabulary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created 2018/4/14.
 *
 * @author HongTao
 */

public class EnglishNewsActivity extends BaseActivity {
    @BindView(R.id.english_news_wv_details)
    WebView mWvDetails;

    private static final String ENGLISH_NEWS_URL = "english_news_url";

    public static void startActivity(String url, Context context) {
        Intent intent = new Intent(context, EnglishNewsActivity.class);
        intent.putExtra(ENGLISH_NEWS_URL, url);
        context.startActivity(intent);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_english_news;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        mWvDetails.loadUrl(getIntent().getStringExtra(ENGLISH_NEWS_URL));
    }

}
