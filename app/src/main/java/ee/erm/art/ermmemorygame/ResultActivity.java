package ee.erm.art.ermmemorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by teras on 24.03.18.
 */

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static Integer userScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        ImageButton homeButton = findViewById(R.id.reset);
        TextView score = findViewById(R.id.textView3);
        score.setText(userScore.toString() + "/10");
        homeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.reset) {
            finish();
        }
    }
}
