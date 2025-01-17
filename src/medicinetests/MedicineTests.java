package medicinetests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import medicinetests.model.General;
import medicinetests.utils.Constants;

public class MedicineTests {

    public static ArrayList<General> firstSection;
    public static ArrayList<General> secondSection;
    public static ArrayList<General> thirdSection;

    public static ArrayList<String> sectionTheme = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        MedicineTests tests = new MedicineTests();

        ArrayList<Integer> listRandomRangesUkr = tests.randomQuestionsNumbers(tests.loadFiles(new File(Constants.BLOCK_1).getAbsolutePath()));
        ArrayList<Integer> listRandomRangesEng = tests.randomQuestionsNumbers(tests.loadFiles(new File(Constants.BLOCK_2).getAbsolutePath()));
        ArrayList<Integer> listRandomRangesUkr2 = tests.randomQuestionsNumbers(tests.loadFiles(new File(Constants.BLOCK_3).getAbsolutePath()));

        ArrayList<String> listDataUkr = tests.readFile(new File(Constants.BLOCK_1).getAbsolutePath());
        ArrayList<String> listDataEng = tests.readFile(new File(Constants.BLOCK_2).getAbsolutePath());
        ArrayList<String> listDataUkr2 = tests.readFile(new File(Constants.BLOCK_3).getAbsolutePath());

        firstSection = tests.listReadyQuestions(listDataUkr, listRandomRangesUkr);
        secondSection = tests.listReadyQuestions(listDataEng, listRandomRangesEng);
        thirdSection = tests.listReadyQuestions(listDataUkr2, listRandomRangesUkr2);

        new AuthForm().setVisible(true);
    }

    private int loadFiles(String path) {
        int countOfLines = 0;

        try {
            System.setProperty("file.encoding", "UTF-8");
            Field charset = Charset.class.getDeclaredField("defaultCharset");
            charset.setAccessible(true);
            charset.set(null, null);

            File file = new File(path);
            FileReader fr = new FileReader(file);
            
            try (BufferedReader reader = new BufferedReader(fr)) {
                String lines = "";

                while (lines != null) {
                    lines = reader.readLine();
                    countOfLines++;
                }
                countOfLines++;
            }
        } catch (IOException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException ex) {
            System.out.println(ex.getMessage());
        }

        return countOfLines;
    }

    private ArrayList<Integer> randomQuestionsNumbers(int lines) {
        int countOfQuestions = (lines - 2) / 6;

        if (countOfQuestions < Constants.COUNT_OF_QUESTIONS_FROM_ONE_FILE) {
            JOptionPane.showMessageDialog(null, "Кількість запитань у файлі повинна бути більшою за " + Constants.COUNT_OF_QUESTIONS_FROM_ONE_FILE + ".");
            System.exit(1);
        }

        int countQuestionsForRandom = countOfQuestions - Constants.COUNT_OF_QUESTIONS_FROM_ONE_FILE;

        int randomNumberForBegin = MedicineTests.getRandomNumberInRange(countQuestionsForRandom);
        int randomNumberForEnd = randomNumberForBegin + Constants.COUNT_OF_QUESTIONS_FROM_ONE_FILE;

        ArrayList<Integer> questionNumbersRanges = new ArrayList<>();

        for (int i = randomNumberForBegin; i < randomNumberForEnd; i++) {
            questionNumbersRanges.add(i);
        }

        Collections.shuffle(questionNumbersRanges);

        return questionNumbersRanges;
    }

    private ArrayList<String> readFile(String filePath) throws IOException {
        ArrayList<String> data = new ArrayList<>();

        try {
            System.setProperty("file.encoding", "UTF-8");
            Field charset = Charset.class.getDeclaredField("defaultCharset");
            charset.setAccessible(true);
            charset.set(null, null);

            File file = new File(filePath);
            FileReader fr = new FileReader(file);

            try (BufferedReader reader = new BufferedReader(fr)) {
                String lines = reader.readLine();
                sectionTheme.add(lines);

                while (lines != null) {
                    lines = reader.readLine();
                    data.add(lines);
                }
            }
        } catch (IOException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException ex) {
            System.out.println(ex.getMessage());
        }

        return data;
    }

    private ArrayList<General> listReadyQuestions(ArrayList<String> dataAll, ArrayList<Integer> random60Numbers) {
        ArrayList<General> generalList = new ArrayList<>();

        for (int i = 0; i < random60Numbers.size(); i++) {
            General object = new General();

            int questionNumber = random60Numbers.get(i);
            int questionRow = questionNumber * 6;

            object.setQuestion(dataAll.get(questionRow));

            List<Map<String, Boolean>> answers = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                Map<String, Boolean> answer = new HashMap<>();

                if (j == 0) {
                    answer.put(dataAll.get(questionRow + (j + 1)), true);
                } else {
                    answer.put(dataAll.get(questionRow + (j + 1)), false);
                }

                answers.add(answer);
            }

            Collections.shuffle(answers);

            object.setAnswers(answers);

            generalList.add(object);
        }

        return generalList;
    }

    private static int getRandomNumberInRange(int max) {
        if (0 >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();

        return r.nextInt(max + 1);
    }
}
