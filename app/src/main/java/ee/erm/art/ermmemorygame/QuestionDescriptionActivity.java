package ee.erm.art.ermmemorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by teras on 24.03.18.
 */

public class QuestionDescriptionActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Question> questionList;
    private Integer questionIndex;
    private Integer answeredQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_desc);

        questionList = (List<Question>) getIntent().getSerializableExtra("question");
        questionIndex = getIntent().getIntExtra("questionIndex", 0);
        Question question = questionList.get(questionIndex);

        answeredQuestion = getIntent().getIntExtra("answeredQuestion", 0);
        TextView descriptionResult = findViewById(R.id.descriptionResult);
        if(answeredQuestion.equals(questionList.get(questionIndex).getCorrectAnswer())){
            switch (MLString.getCurrentLanguage()){
                case English:
                    descriptionResult.setText("Correct!");
                    break;
                case Estonian:
                    descriptionResult.setText("Õige!");
                    break;
                case Russian:
                    descriptionResult.setText("Правилно!");
                    break;
            }
        }
        else{
            switch (MLString.getCurrentLanguage()){
                case English:
                    descriptionResult.setText("Incorrect! The right answer was: ");
                    break;
                case Estonian:
                    descriptionResult.setText("Vale! Õige vastus oli: ");
                    break;
                case Russian:
                    descriptionResult.setText("Неправилно!");
            }
        }



        ImageButton nextButton = findViewById(R.id.questionForward);

        ImageView imageView = findViewById(R.id.descriptionImage);
        imageView.setImageResource(getDrawableImage());

        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.questionForward) {
            if (questionIndex + 1 < questionList.size()) {
                Intent intent = new Intent(QuestionDescriptionActivity.this, QuestionActivity.class);
                intent.putExtra("question", (Serializable) questionList);
                intent.putExtra("questionIndex", questionIndex + 1);
                finish();
                startActivity(intent);
            } else {
                Intent intent = new Intent(QuestionDescriptionActivity.this, ResultActivity.class);
                finish();
                startActivity(intent);
            }
        } else if (view.getId() == R.id.reset) {
            finish();
        }
    }

    private int getDrawableImage() {
        return R.drawable.ic_bg_pink;
    }
}

