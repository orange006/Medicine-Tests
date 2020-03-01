package medicinetests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

public class MedicineTests {
    
    int countLines = 0;
    String path1;
    public static ArrayList<General> firstSection;
    
    public static void main(String[] args) throws IOException {
        
        MedicineTests tests = new MedicineTests();
        
        tests.loadFiles();
        
        ArrayList<Integer> listRandomRanges = tests.randomQuestionsNumbers();
        ArrayList<String> listData = tests.readFile();
        
        firstSection = tests.listReadyQuestions(listData, listRandomRanges);
        
        Design design = new Design();
        design.setVisible(true);
    }
    
    public void loadFiles() {
        try {
            System.setProperty("file.encoding", "UTF-8");
            Field charset = Charset.class.getDeclaredField("defaultCharset");
            charset.setAccessible(true);
            charset.set(null, null);
            
            File nameFile = new File("questionsUKR.txt");
            path1 = nameFile.getAbsolutePath();
            
            File file = new File(path1);
            FileReader fr = new FileReader(file);
            try (BufferedReader reader = new BufferedReader(fr)) {
                String lines = "";
                
                while (lines != null) {
                    lines = reader.readLine();
                    countLines++;
                }
                countLines++;
            }
        } catch (Exception ex) {
            System.out.println("EXCEPTION 1");
        }
    }
    
    public ArrayList<Integer> randomQuestionsNumbers() {
        int countOfQuestions = (countLines - 2) / 6;
        
        if (countOfQuestions < 60) {
            JOptionPane.showMessageDialog(null, "Кількість запитань в файлі повинна бути більшою за 60.");
            System.exit(1);
        }
        
        int countQuestionsForRandom = countOfQuestions - 60;
        
        int randomNumberForBegin = MedicineTests.getRandomNumberInRange(0, countQuestionsForRandom);
        int randomNumberForEnd = randomNumberForBegin + 60;
        
        ArrayList<Integer> questionNumbersRanges = new ArrayList<>();
        
        for (int i = randomNumberForBegin; i < randomNumberForEnd; i++) {
            questionNumbersRanges.add(i);
        }
        
        Collections.shuffle(questionNumbersRanges);
        
        return questionNumbersRanges;
    }
    
    public ArrayList<String> readFile() throws IOException {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(path1);
        FileReader fr = new FileReader(file);
        try (BufferedReader reader = new BufferedReader(fr)) {
            String lines = reader.readLine();
            data.add(lines);
            
            while (lines != null) {
                lines = reader.readLine();
                data.add(lines);
            }
        }
        return data;
    }
    
    public ArrayList<General> listReadyQuestions(ArrayList<String> dataAll, ArrayList<Integer> random60Numbers) {
        ArrayList<General> generalList = new ArrayList<>();
        
        for (int i = 0; i < random60Numbers.size(); i++) {
            General object = new General();
            
            int questionNumber = random60Numbers.get(i);
            int questionRow = questionNumber * 6;
            
            String question = dataAll.get(questionRow);
            String answer1True = dataAll.get(questionRow + 1);
            String answer2False = dataAll.get(questionRow + 2);
            String answer3False = dataAll.get(questionRow + 3);
            String answer4False = dataAll.get(questionRow + 4);
            String answer5False = dataAll.get(questionRow + 5);
            
            object.setQuestionNumber(i);
            object.setQuestion(question);
            
            List<Map<String, Boolean>> answers = new ArrayList<>();
            
            Map<String, Boolean> answer1 = new HashMap<>();
            Map<String, Boolean> answer2 = new HashMap<>();
            Map<String, Boolean> answer3 = new HashMap<>();
            Map<String, Boolean> answer4 = new HashMap<>();
            Map<String, Boolean> answer5 = new HashMap<>();
            
            answer1.put(answer1True, true);
            answer2.put(answer2False, false);
            answer3.put(answer3False, false);
            answer4.put(answer4False, false);
            answer5.put(answer5False, false);
            
            answers = Arrays.asList(answer1, answer2, answer3, answer4, answer5);
            
            Collections.shuffle(answers);
            
            object.setAnswers(answers);
            
            generalList.add(object);
        }
        
        return generalList;
    }
    
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        
        return r.nextInt((max - min) + 1) + min;
    }
}

class General {
    
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
