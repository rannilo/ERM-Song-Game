package ee.erm.art.ermmemorygame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by teras on 24.03.18.
 */

public class Question implements Serializable {
    private String fileName;
    private List<String> answers;
    private Integer correctAnswer;
    private Integer indexInFile;

    public Question() {
        this.fileName = "default_picture.png";
        this.answers = new ArrayList<>();
        this.correctAnswer = 0;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }

    public void setAnswers(List<String> answers){
        this.answers = answers;
    }

    public String getAnswer(int index) {
        return answers.get(index);
    }
    public Integer getCorrectAnswer(){
        return correctAnswer;
    }
    public void setIndexInFile(Integer in){
        indexInFile = in;
    }
    public Integer getIndexInFile(){
        return indexInFile;
    }

    @Override
    public String toString() {
        return "Question{" +
                "fileName='" + fileName + '\'' +
                ", answers=" + answers +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
