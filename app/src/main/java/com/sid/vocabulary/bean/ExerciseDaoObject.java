package com.sid.vocabulary.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */
@Entity
public class ExerciseDaoObject {
    @Id(autoincrement = true)
    private Long _id;
    @NotNull
    int wordId;
    @NotNull
    private String word;
    @NotNull
    private String rightTranslation;
    @NotNull
    private String wrongTranslation1;
    @NotNull
    private String wrongTranslation2;
    @NotNull
    private String wrongTranslation3;


    @Generated(hash = 896733395)
    public ExerciseDaoObject(Long _id, int wordId, @NotNull String word,
            @NotNull String rightTranslation, @NotNull String wrongTranslation1,
            @NotNull String wrongTranslation2, @NotNull String wrongTranslation3) {
        this._id = _id;
        this.wordId = wordId;
        this.word = word;
        this.rightTranslation = rightTranslation;
        this.wrongTranslation1 = wrongTranslation1;
        this.wrongTranslation2 = wrongTranslation2;
        this.wrongTranslation3 = wrongTranslation3;
    }

    @Generated(hash = 1527838637)
    public ExerciseDaoObject() {
    }
    

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getRightTranslation() {
        return this.rightTranslation;
    }

    public void setRightTranslation(String rightTranslation) {
        this.rightTranslation = rightTranslation;
    }

    public String getWrongTranslation1() {
        return this.wrongTranslation1;
    }

    public void setWrongTranslation1(String wrongTranslation1) {
        this.wrongTranslation1 = wrongTranslation1;
    }

    public String getWrongTranslation2() {
        return this.wrongTranslation2;
    }

    public void setWrongTranslation2(String wrongTranslation2) {
        this.wrongTranslation2 = wrongTranslation2;
    }

    public String getWrongTranslation3() {
        return this.wrongTranslation3;
    }

    public void setWrongTranslation3(String wrongTranslation3) {
        this.wrongTranslation3 = wrongTranslation3;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }
}
