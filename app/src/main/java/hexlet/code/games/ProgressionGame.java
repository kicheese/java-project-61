package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class ProgressionGame {
    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What number is missing in the progression?");

        for (int i = 0; i < Engine.getRoundCount(); i++) {
            final int progressionLength = 10;
            String[] progressions = new String[progressionLength];

            final int  stepStart = 1;
            final int  stepEnd = 5;

            final int  startValueStart = 1;
            final int  startValueEnd = 20;

            final int  hideValueStart = 0;
            final int  hideValueEnd = 9;

            int step = Engine.getRandomNumber(stepStart, stepEnd);
            int startValue = Engine.getRandomNumber(startValueStart, startValueEnd);
            int hideValue = Engine.getRandomNumber(hideValueStart, hideValueEnd);

            int correctAnswer = 0;

            StringBuilder result = new StringBuilder();

            for (int j = 0; j < progressions.length; j++) {
                if (j == hideValue) {
                    result.append(".. ");
                    correctAnswer = startValue;
                } else {
                    result.append(startValue).append(" ");
                }
                startValue += step;
            }

            Engine.showQuestion(String.valueOf(result).trim());

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
