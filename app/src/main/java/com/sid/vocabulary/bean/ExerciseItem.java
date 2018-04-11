package com.sid.vocabulary.bean;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class ExerciseItem {
    private String translation;
    private boolean isCorrect;

    public ExerciseItem(String translation, boolean isCorrect) {
        this.translation = translation;
        this.isCorrect = isCorrect;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
