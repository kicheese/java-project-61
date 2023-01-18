package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Scanner;

public class ProgressionGame {
    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What number is missing in the progression?");

        for (int i = 0; i < Engine.roundCount; i++) {
            String[] progressions = new String[10];

            int step = Engine.getRandomNumber(1, 5);
            int startValue = Engine.getRandomNumber(1, 20);
            int hideValue = Engine.getRandomNumber(0, 9);

            int correctAnswer = 0;

            for (int j = 0; j < progressions.length; j++) {
                if (j == hideValue) {
                    progressions[j] = "..";
                    correctAnswer = startValue;
                } else {
                    progressions[j] = Integer.toString(startValue);
                }
                startValue += step;
            }

            String question = Arrays.toString(progressions);

            Engine.showQuestion(question.substring(1, question.length() - 1));

            String answer = scanner.next();
            Engine.showAnswer(answer);

            boolean hasWrongAnswer = Engine.checkCorrectAnswerAndShowMessage(
                Integer.toString(correctAnswer), answer, userName
            );

            if (hasWrongAnswer) {
                return;
            }
        }
        Engine.showCongratulations(userName);
    }
}
