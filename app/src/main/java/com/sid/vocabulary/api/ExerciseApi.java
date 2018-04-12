package com.sid.vocabulary.api;

import com.sid.vocabulary.VocabularyApplication;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class ExerciseApi {
    private static final String HOST = "http://111.230.16.49:8080/vocabulary/";

    private static final String GET_WORD_IN_ENGLISH = "getWordInEnglish/";
    private static final String GET_WORD_IN_CHINESE = "getWordInChinese/";

    public static String getWordInEnglishApi(String userId, int wordNum) throws IOException {
        Request request = new Request.Builder()
                .url(HOST + GET_WORD_IN_ENGLISH + userId + "/" + wordNum)
                .build();
        Response response = VocabularyApplication.getOkHttpClient().newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body().string();
    }

    public static String getWordInChinesehApi(String userId, int wordNum) throws IOException {
        Request request = new Request.Builder()
                .url(HOST + GET_WORD_IN_CHINESE + userId + "/" + wordNum)
                .build();
        Response response = VocabularyApplication.getOkHttpClient().newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body().string();
    }
}
