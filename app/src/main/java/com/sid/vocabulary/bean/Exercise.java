package com.sid.vocabulary.bean;

import java.util.List;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class Exercise {

    private int wordId;
    private String word;
    private String translation;
    private List<String> wrongTranslation;

    public Exercise(int wordId, String word, String translation, List<String> wrongTranslation) {
        this.wordId = wordId;
        this.word = word;
        this.translation = translation;
        this.wrongTranslation = wrongTranslation;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public List<String> getWrongTranslation() {
        return wrongTranslation;
    }

    public void setWrongTranslation(List<String> wrongTranslation) {
        this.wrongTranslation = wrongTranslation;
    }
}
