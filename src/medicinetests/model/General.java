package medicinetests.model;

import java.util.List;
import java.util.Map;

public class General {

    private String question;
    private List<Map<String, Boolean>> answers;

    public General() {}

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(List<Map<String, Boolean>> answers) {
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public List<Map<String, Boolean>> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "General{" + "question=" + question + ", answers=" + answers + '}';
    }
}