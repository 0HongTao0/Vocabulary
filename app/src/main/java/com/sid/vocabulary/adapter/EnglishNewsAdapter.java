package com.sid.vocabulary.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sid.vocabulary.R;
import com.sid.vocabulary.bean.EnglishNews;

import java.util.List;

/**
 * Created 2018/4/13.
 *
 * @author HongTao
 */

public class EnglishNewsAdapter extends RecyclerView.Adapter<EnglishNewsAdapter.EnglishNewsHolder> {
    private List<EnglishNews> mEnglishNews;
    private EnglishNewsAdapter.OnItemClickListener mOnItemClickListener;

    public EnglishNewsAdapter(List<EnglishNews> englishNews) {
        this.mEnglishNews = englishNews;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public EnglishNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_english_news, parent, false);
        return new EnglishNewsHolder(view);
    }

    @Override
    public void onBindViewHolder(EnglishNewsHolder holder, int position) {
        final EnglishNews englishNews = mEnglishNews.get(position);
        holder.mTvTitle.setText(englishNews.getTitle());
        holder.mTvDescription.setText(englishNews.getDescription());
        Glide.with(holder.mIvPicture.getContext())
                .load(englishNews.getUrlToImage())
                .error(R.drawable.error)
                .placeholder(R.drawable.loding)
                .fitCenter()
                .centerCrop()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.mIvPicture);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnItemClickListener) {
                    mOnItemClickListener.onItemClick(englishNews);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEnglishNews == null ? 0 : mEnglishNews.size();
    }

    protected static class EnglishNewsHolder extends RecyclerView.ViewHolder {
        private TextView mTvTitle;
        private TextView mTvDescription;
        private ImageView mIvPicture;

        public EnglishNewsHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.english_news_tv_title);
            mTvDescription = itemView.findViewById(R.id.english_news_tv_description);
            mIvPicture = itemView.findViewById(R.id.english_news_iv_picture);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(EnglishNews englishNews);
    }
}
