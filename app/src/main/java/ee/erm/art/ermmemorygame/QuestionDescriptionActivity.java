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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_desc);

        questionList = (List<Question>)getIntent().getSerializableExtra("question");
        questionIndex = getIntent().getIntExtra("questionIndex", 0);
        Question question = questionList.get(questionIndex);

        TextView questionDescription = findViewById(R.id.questionDescription);
        questionDescription.setText(question.getDescription());

        ImageButton nextButton = findViewById(R.id.questionForward);

        ImageView imageView = findViewById(R.id.descriptionImage);
        imageView.setImageResource(getDrawableImage());

        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.questionForward) {
            if(questionIndex + 1 < questionList.size()) {
                Intent intent = new Intent(QuestionDescriptionActivity.this, QuestionActivity.class);
                intent.putExtra("question", (Serializable) questionList);
                intent.putExtra("questionIndex", questionIndex + 1);
                finish();
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(QuestionDescriptionActivity.this, ResultActivity.class);
                finish();
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.reset) {
            finish();
        }
    }

    private int getDrawableImage(){
        switch (questionIndex){
            case 0:
                return R.drawable.pic1;
            case 1:
                return R.drawable.pic2;
            case 2:
                return R.drawable.pic3;
            case 3:
                return R.drawable.pic4;
            case 4:
                return R.drawable.pic5;
            case 5:
                return R.drawable.pic6;
            default:
                return R.drawable.ic_bg_pink;
        }
    }
}
