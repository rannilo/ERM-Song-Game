package ee.erm.art.ermmemorygame;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by teras on 24.03.18.
 */

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Question> questionList;
    private Integer questionIndex;
    private RadioGroup radioGroup;
    private int correctAnswer;
    private MediaPlayer mp;
    private Button playBtn;
    private SeekBar volumeSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        questionList = (List<Question>)getIntent().getSerializableExtra("question");
        questionIndex = getIntent().getIntExtra("questionIndex", 0);
        Question question = questionList.get(questionIndex);
        correctAnswer = question.getCorrectAnswer();

        RadioButton answer0 = findViewById(R.id.questionAnswer0);
        RadioButton answer1 = findViewById(R.id.questionAnswer1);
        RadioButton answer2 = findViewById(R.id.questionAnswer2);
        RadioButton answer3 = findViewById(R.id.questionAnswer3);

        answer0.setText(question.getAnswer(0));
        answer1.setText(question.getAnswer(1));
        answer2.setText(question.getAnswer(2));
        answer3.setText(question.getAnswer(3));


        playBtn = (Button)findViewById(R.id.playBtn);

        //Media player
        mp = MediaPlayer.create(this, getDrawableSong());
        mp.seekTo(0);
        mp.start();
        mp.setLooping(true);

        /*mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                mp.release();
                System.out.println("ERROR: " + i + "; " + i1);
                return true;
            }
        });*/


        //volume bar
        volumeSeekbar = (SeekBar)findViewById(R.id.seekBar);
        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        volumeSeekbar.setMax(audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        volumeSeekbar.setProgress(audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC));
        volumeSeekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                                progress, 0);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        ImageButton nextButton = findViewById(R.id.questionForward);
        ImageButton homeButton = findViewById(R.id.reset);

        radioGroup = findViewById(R.id.questionAnswerGroup);

        nextButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
    }

    public void playBtnClick(View view){
        if(!mp.isPlaying()){
            mp.start();
            playBtn.setBackgroundResource(android.R.drawable.ic_media_pause);
        }
        else{
            mp.pause();
            playBtn.setBackgroundResource(android.R.drawable.ic_media_play);
        }
    }

    @Override
    public void onClick(View view) {
        mp.release();
        if(view.getId() == R.id.questionForward) {
            if(radioGroup.getCheckedRadioButtonId() != -1) {
                int selectedValue = 0;

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.questionAnswer0:
                        selectedValue = 0;
                        break;
                    case R.id.questionAnswer1:
                        selectedValue = 1;
                        break;
                    case R.id.questionAnswer2:
                        selectedValue = 2;
                        break;
                    case R.id.questionAnswer3:
                        selectedValue = 3;
                        break;
                }
                if(selectedValue==correctAnswer){
                    ResultActivity.userScore++;
                }

                Intent intent = new Intent(QuestionActivity.this, QuestionDescriptionActivity.class);
                intent.putExtra("question", (Serializable) questionList);
                intent.putExtra("questionIndex", questionIndex);
                intent.putExtra("answeredQuestion", selectedValue);
                Log.i("ERM", "" + selectedValue);
                finish();
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.reset) {
            finish();
        }
    }

    public int getDrawableSong(){
        switch (questionList.get(questionIndex).getIndexInFile()){
            case 0:
                return R.raw.s1;
            case 1:
                return R.raw.s2;
            case 2:
                return R.raw.s3;
            case 3:
                return R.raw.s4;
            case 4:
                return R.raw.s5;
            case 5:
                return R.raw.s6;
            case 6:
                return R.raw.s7;
            case 7:
                return R.raw.s8;
            case 8:
                return R.raw.s9;
            case 9:
                return R.raw.s10;
            case 10:
                return R.raw.s11;
            case 11:
                return R.raw.s12;
            case 12:
                return R.raw.s13;
            case 13:
                return R.raw.s14;
            case 14:
                return R.raw.s15;
            case 15:
                return R.raw.s16;
            case 16:
                return R.raw.s17;
            case 17:
                return R.raw.s18;
            case 18:
                return R.raw.s19;
            case 19:
                return R.raw.s20;
            case 20:
                return R.raw.s21;
            case 21:
                return R.raw.s22;
            case 22:
                return R.raw.s23;
            case 23:
                return R.raw.s24;
            case 24:
                return R.raw.s25;
            case 25:
                return R.raw.s26;
            case 26:
                return R.raw.s27;
            case 27:
                return R.raw.s28;
            case 28:
                return R.raw.s29;
            case 29:
                return R.raw.s30;
            case 30:
                return R.raw.s31;
            case 31:
                return R.raw.s32;
            case 32:
                return R.raw.s33;
            case 33:
                return R.raw.s34;
            case 34:
                return R.raw.s35;
            case 35:
                return R.raw.s36;
            case 36:
                return R.raw.s37;
            case 37:
                return R.raw.s38;
            case 38:
                return R.raw.s39;
            case 39:
                return R.raw.s40;
            case 40:
                return R.raw.s41;
            case 41:
                return R.raw.s42;
            case 42:
                return R.raw.s43;
            case 43:
                return R.raw.s44;
            case 44:
                return R.raw.s45;
            default:
                return R.raw.s1;
        }
    }
}
