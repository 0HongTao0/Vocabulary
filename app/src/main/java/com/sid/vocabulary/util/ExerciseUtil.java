package com.sid.vocabulary.util;

import com.sid.vocabulary.bean.Exercise;
import com.sid.vocabulary.bean.ExerciseDaoObject;
import com.sid.vocabulary.bean.ExerciseItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created 2018/4/11.
 *
 * @author HongTao
 */

public class ExerciseUtil {

    public static List<ExerciseItem> getExerciseItemList(Exercise exercise) {
        List<ExerciseItem> list = new ArrayList<>();
        list.add(new ExerciseItem(exercise.getTranslation(), true));
        for (int i = 0; i < exercise.getWrongTranslation().size(); i++) {
            list.add(new ExerciseItem(exercise.getWrongTranslation().get(i), false));
        }
        Collections.shuffle(list);
        return list;
    }

    public static Exercise converseToExercise(ExerciseDaoObject exerciseDaoObject) {
        List<String> wrongTranslations = new ArrayList<>();
        wrongTranslations.add(exerciseDaoObject.getWrongTranslation1());
        wrongTranslations.add(exerciseDaoObject.getWrongTranslation2());
        wrongTranslations.add(exerciseDaoObject.getWrongTranslation3());
        return new Exercise(exerciseDaoObject.getWordId()
                , exerciseDaoObject.getWord()
                , exerciseDaoObject.getRightTranslation()
                , wrongTranslations);
    }

    public static List<Exercise> converseToExercise(List<ExerciseDaoObject> exerciseDaoObjectList) {
        List<Exercise> list = new ArrayList<>();
        for (int i = 0; i < exerciseDaoObjectList.size(); i++) {
            List<String> wrongTranslations = new ArrayList<>();
            wrongTranslations.add(exerciseDaoObjectList.get(i).getWrongTranslation1());
            wrongTranslations.add(exerciseDaoObjectList.get(i).getWrongTranslation2());
            wrongTranslations.add(exerciseDaoObjectList.get(i).getWrongTranslation3());
            list.add(new Exercise(exerciseDaoObjectList.get(i).getWordId()
                    , exerciseDaoObjectList.get(i).getWord()
                    , exerciseDaoObjectList.get(i).getRightTranslation()
                    , wrongTranslations));
        }
        return list;
    }

    public static List<ExerciseDaoObject> converseToExerciseDaoObject(List<Exercise> list) {
        List<ExerciseDaoObject> daoObjectList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ExerciseDaoObject exerciseDaoObject = new ExerciseDaoObject();
            exerciseDaoObject.setWord(list.get(i).getWord());
            exerciseDaoObject.setRightTranslation(list.get(i).getTranslation());
            exerciseDaoObject.setWordId(list.get(i).getWordId());
            exerciseDaoObject.setWrongTranslation1(list.get(i).getWrongTranslation().get(0));
            exerciseDaoObject.setWrongTranslation2(list.get(i).getWrongTranslation().get(1));
            exerciseDaoObject.setWrongTranslation3(list.get(i).getWrongTranslation().get(2));
            daoObjectList.add(exerciseDaoObject);
        }
        return daoObjectList;
    }
}
