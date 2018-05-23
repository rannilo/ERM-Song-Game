package ee.erm.art.ermmemorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import org.w3c.dom.Text;

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

        TextView resultText = findViewById(R.id.scoreText1);
        switch (MLString.getCurrentLanguage()) {
            case Russian:
                resultText.setText("Твой результат");
                break;
            case Estonian:
                resultText.setText("Sinu tulemus on");
                break;
            case English:
                resultText.setText("Your score is");
        }

        TextView score = findViewById(R.id.score);
        score.setText(userScore.toString() + "/10");

        //custom text based on score
        TextView resultDesc = findViewById(R.id.scoreText2);
        if (userScore >= 10) {
            switch (MLString.getCurrentLanguage()) {
                case English:
                    resultDesc.setText("Congratulations! You're a real music expert! We suspect telepathic communication between you and Nancy/ Pearu Paulus, how else could you have achieved such great results? ");
                    break;
                case Estonian:
                    resultDesc.setText("Palju õnne! Oled tõeline muusikaekspert! Äkki on sinu ning Nancy või Pearu Pauluse vahel telepaatiline side, sest kuidas muidu on võimalik nii suurepärast tulemust saavutada? ");
                    break;
                case Russian:
                    resultDesc.setText("Счастья! Ты настоящий музыкальный эксперт! Вдруг между тобой и Ненси или Пеару существует телепатическая свясь, как иначе возможны такие прекрасные достижения?");
                    break;
            }
        } else if (userScore >= 7 && userScore <= 9) {
            switch (MLString.getCurrentLanguage()) {
                case English:
                    resultDesc.setText("Not bad, not bad at all! Your knowledge of music is really impressive. But if the theme were the less known 90s music, we wouldn’t dare to bet on you. ");
                    break;
                case Estonian:
                    resultDesc.setText("Pole paha, pole üldse paha! Sinu muusikaalased teadmised avaldavad tõesti muljet. Aga kui teemaks oleks 90ndate vähemtuntud palad, siis sinu võidu peale kihla vedada veel ei julgeks.");
                    break;
                case Russian:
                    resultDesc.setText("Неплохо, совсем неплохо! Твои музыкальные познания выражают действительно впечатление. А если темой девяностых были бы менее известные мелодии, я бы не посмела держать пари на твою победу.");
                    break;
            }
        } else if (userScore >= 4 && userScore <= 6) {
            switch (MLString.getCurrentLanguage()) {
                case English:
                    resultDesc.setText("A good average! Your performance wasn’t as magnificent as the voice of Marju Länik but you still have hope, so perhaps one day....");
                    break;
                case Estonian:
                    resultDesc.setText("Tubli keskmine! Sooritus pole küll sama hiilgav kui Marju Läniku lauluhääl, aga küll ta ühel heal päeval sinnani küündib!");
                    break;
                case Russian:
                    resultDesc.setText("Среднее! Исполнение не такое блестящее, как голос Марью Ляник, но в какой-то день обязательно этого достигнешь! ");
                    break;
            }
        } else if (userScore >= 1 && userScore <= 3) {
            switch (MLString.getCurrentLanguage()) {
                case English:
                    resultDesc.setText(" Seems you have heard something but there is a lot of room for improvement.  Listen to a little of Estin, dance to a few Terminator tracks and enjoy the unforgettable hits of 2 Quick Start. Only then will you become invincible! ");
                    break;
                case Estonian:
                    resultDesc.setText("Midagi oled nagu kuulnud, aga arenguruumi on omajagu. Kuula pisut Estinit, tantsi mõne Terminaatori loo järgi ja naudi 2 Quick Starti unustamatuid hitte. Niimoodi saad võitmatuks!");
                    break;
                case Russian:
                    resultDesc.setText("Что-то вроде ты слышала, но путь развития еще долгий. Послушай немного Эстин, станцуй под мелодию Терминатора и насладись хитами 2 Quiск Старт. Так ты будешь непобедимой!");
                    break;
            }
        } else if (userScore <= 0) {
            switch (MLString.getCurrentLanguage()) {
                case English:
                    resultDesc.setText("Hard to say, what went wrong here: perhaps you were thinking about a wrong decade? Or ticked the wrong box? Ten times in a row? Don’t worry- happens to the best of us!");
                    break;
                case Estonian:
                    resultDesc.setText("Raske öelda, mis nüüd viltu läks: äkki mõlkus meeles vale kümnend? Või vajutasid õigest kastist mööda? Kümme korda järjest? Juhtub ka parimatel!");
                    break;
                case Russian:
                    resultDesc.setText("Трудно сказать, что пошло не так: может в памяти было не то десятилетие? Может вы нажали мимо квадрата? Десять раз подряд? Случается и с другими!");
                    break;
            }
        }
        homeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.reset) {
            finish();
        }
    }
}
