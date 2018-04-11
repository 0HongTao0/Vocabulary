package com.sid.vocabulary.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sid.vocabulary.R;
import com.sid.vocabulary.bean.ExerciseItem;

import java.util.List;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class ExerciseRvAdapter extends RecyclerView.Adapter<ExerciseRvAdapter.ExerciseRvViewHolder> {
    private static final String TAG = ExerciseRvAdapter.class.getSimpleName();

    private List<ExerciseItem> mExerciseItemList;
    private ExerciseRvAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public ExerciseRvAdapter(List<ExerciseItem> list) {
        mExerciseItemList = list;
    }

    @Override
    public ExerciseRvViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_exercise, parent, false);
        final ExerciseRvViewHolder exerciseRvViewHolder = new ExerciseRvViewHolder(view);
        exerciseRvViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExerciseItem exerciseItem = mExerciseItemList.get(exerciseRvViewHolder.getAdapterPosition());
                Log.d(TAG, "onClick: " + exerciseItem.getTranslation());
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(exerciseItem, exerciseItem.isCorrect());
                }
            }
        });
        return exerciseRvViewHolder;
    }

    @Override
    public void onBindViewHolder(ExerciseRvViewHolder holder, int position) {
        ExerciseItem exerciseItem = mExerciseItemList.get(position);
        holder.mTextView.setText(exerciseItem.getTranslation());
    }

    @Override
    public int getItemCount() {
        return mExerciseItemList == null ? 0 : mExerciseItemList.size();
    }

    public static class ExerciseRvViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ExerciseRvViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.item_exercise_tv_translation);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ExerciseItem exerciseItem, boolean isCorrect);
    }
}
