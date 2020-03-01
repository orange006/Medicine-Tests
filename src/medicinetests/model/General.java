package medicinetests.model;

import java.util.List;
import java.util.Map;

public class General {

    private int questionNumber;
    private String question;
    private List<Map<String, Boolean>> answers;

    public General() {}

    public General(int questionNumber, String question, List<Map<String, Boolean>> answers) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answers = answers;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(List<Map<String, Boolean>> answers) {
        this.answers = answers;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public List<Map<String, Boolean>> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "General{" + "questionNumber=" + questionNumber + ", question=" + question + ", answers=" + answers + '}';
    }
}