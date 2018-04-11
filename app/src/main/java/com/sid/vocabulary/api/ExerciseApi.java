package com.sid.vocabulary.api;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class ExerciseApi {
    private static final String HOST = "http://111.230.16.49:8080/vocabulary/";

    private static final String GET_WORD_IN_ENGLISH = "getWordInEnglish/";
    private static final String GET_WORD_IN_CHINESE = "getWordInChinese/";

    public static String getWordInEnglishApi(String userId, int wordNum) {
        return "{\n" +
                "    \"code\": 200,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"wordId\": 37325,\n" +
                "            \"word\": \"fucking\",\n" +
                "            \"translation\": \"adj. 可恶的，十足的，异乎寻常的\\nadv. 非常地，无比地\",\n" +
                "            \"wrongTranslation\": [\n" +
                "                \"n. 微粒子，微粒状物质\\nadj. 微粒的\",\n" +
                "                \"adv. 崭新,新改,以新方法\",\n" +
                "                \"pron. 我自己\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"wordId\": 37326,\n" +
                "            \"word\": \"cling\",\n" +
                "            \"translation\": \"n. 紧抓,紧贴\\nvi. 粘紧,附着,紧贴\",\n" +
                "            \"wrongTranslation\": [\n" +
                "                \"n. 概观(况),总结\\n[计算机] 概貌\",\n" +
                "                \"n. 高龄, 古老, 古物, 古迹\",\n" +
                "                \"n.贴身衬衣,紧身衣\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

//    public static String getWordInChinesehApi(String userId, int wordNum) {
//
//    }
}
