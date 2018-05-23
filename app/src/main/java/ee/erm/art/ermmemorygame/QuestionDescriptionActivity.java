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
        if(answeredQuestion.equals(question.getCorrectAnswer())){
            switch (MLString.getCurrentLanguage()){
                case English:
                    descriptionResult.setText("Correct! The right answer was: ");
                    break;
                case Estonian:
                    descriptionResult.setText("Õige! Õige vastus oli: ");
                    break;
                case Russian:
                    descriptionResult.setText("Правилно! Правильный ответ был: ");
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
                    descriptionResult.setText("Неправилно! Правильный ответ был: ");
                    break;
            }
        }

        TextView correctAnswerDesc = findViewById(R.id.correctAnswer);
        correctAnswerDesc.setText(question.getAnswer(question.getCorrectAnswer()));

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

    public int getDrawableImage(){
        switch (questionList.get(questionIndex).getIndexInFile()){
            case 0:
                return R.raw.p1;
            case 1:
                return R.raw.p2;
            case 2:
                return R.raw.p3;
            case 3:
                return R.raw.p4;
            case 4:
                return R.raw.p5;
            case 5:
                return R.raw.p6;
            case 6:
                return R.raw.p7;
            case 7:
                return R.raw.p8;
            case 8:
                return R.raw.p9;
            case 9:
                return R.raw.p10;
            case 10:
                return R.raw.p11;
            case 11:
                return R.raw.p12;
            case 12:
                return R.raw.p13;
            case 13:
                return R.raw.p14;
            case 14:
                return R.raw.p15;
            case 15:
                return R.raw.p16;
            case 16:
                return R.raw.p17;
            case 17:
                return R.raw.p18;
            case 18:
                return R.raw.p19;
            case 19:
                return R.raw.p20;
            case 20:
                return R.raw.p21;
            case 21:
                return R.raw.p22;
            case 22:
                return R.raw.p23;
            case 23:
                return R.raw.p24;
            case 24:
                return R.raw.p25;
            case 25:
                return R.raw.p26;
            case 26:
                return R.raw.p27;
            case 27:
                return R.raw.p28;
            case 28:
                return R.raw.p29;
            case 29:
                return R.raw.p30;
            case 30:
                return R.raw.p31;
            case 31:
                return R.raw.p32;
            case 32:
                return R.raw.p33;
            case 33:
                return R.raw.p34;
            case 34:
                return R.raw.p35;
            case 35:
                return R.raw.p36;
            case 36:
                return R.raw.p37;
            case 37:
                return R.raw.p38;
            case 38:
                return R.raw.p39;
            case 39:
                return R.raw.p40;
            case 40:
                return R.raw.p41;
            case 41:
                return R.raw.p42;
            case 42:
                return R.raw.p43;
            case 43:
                return R.raw.p44;
            case 44:
                return R.raw.p45;
            default:
                return R.raw.p1;
        }
    }
}

