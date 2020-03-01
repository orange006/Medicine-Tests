package medicinetests.model;

import java.util.List;
import java.util.Map;

public class General {

    int questionNumber;
    String question;
    List<Map<String, Boolean>> answers;
    boolean userAnswer = false;

    public General() {
    }

    public General(int questionNumber, String question, List<Map<String, Boolean>> answers, boolean userAnswer) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.answers = answers;
        this.userAnswer = userAnswer;
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

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
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

    public boolean isUserAnswer() {
        return userAnswer;
    }

    @Override
    public String toString() {
        return "General{" + "questionNumber=" + questionNumber + ", question=" + question + ", answers=" + answers + ", userAnswer=" + userAnswer + '}';
    }
}