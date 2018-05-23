package ee.erm.art.ermmemorygame;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by    teras on 24.03.18.
 */

public class QuestionReader {

    public static final String FILENAME = "questions.json";

    public static String readFile(AppCompatActivity activity) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(activity.getAssets().open(FILENAME), "UTF-8"));

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null)
        {
            sb.append(line);
        }

        return sb.toString();
    }

    public static List<Question> getQuestions(AppCompatActivity activity) {
        List<Question> questions = new ArrayList<>();
        List<Question> tenQuestions = new ArrayList<>();

        String json;

        try{
            json = readFile(activity);
        }
        catch (IOException e) {
            return questions;
        }

        try {
            JSONArray jsonQuestionArray = new JSONArray(json);
            for(int i = 0; i < jsonQuestionArray.length(); i++) {
                JSONObject jsonQuestion = jsonQuestionArray.getJSONObject(i);
                Question question = new Question();

                question.setCorrectAnswer(jsonQuestion.getInt("correct_answer"));
                question.setFileName(jsonQuestion.getString("music file"));

                ArrayList<String> answers = new ArrayList<>();
                answers.add(jsonQuestion.getString("answer0"));
                answers.add(jsonQuestion.getString("answer1"));
                answers.add(jsonQuestion.getString("answer2"));
                answers.add(jsonQuestion.getString("answer3"));
                question.setAnswers(answers);

                question.setIndexInFile(i);
                questions.add(question);
                Log.i("ERM", jsonQuestion.toString());
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        for(int i = 0; i<10; i++){
            int a = rand.nextInt(questions.size());
            tenQuestions.add(questions.get(a));
            questions.remove(a);
        }
        return tenQuestions;
    }
}
