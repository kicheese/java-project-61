package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GCDGame {
    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < Engine.getRoundCount(); i++) {
            int start = 1;
            int end = 20;

            int firstNumber = Engine.getRandomNumber(start, end);
            int secondNumber = Engine.getRandomNumber(start, end);

            int divider = Math.min(firstNumber, secondNumber);

            int result = divider;

            if (firstNumber != secondNumber) {
                while (firstNumber % divider != 0 || secondNumber % divider != 0) {
                    divider--;
                    result = divider;
                }
            }

            String question = String.format("%s %s", firstNumber, secondNumber);

            Engine.showQuestion(question);

            String answer = scanner.next();
            Engine.showAnswer(answer);

            boolean hasWrongAnswer = Engine.checkCorrectAnswerAndShowMessage(
                Integer.toString(result), answer, userName
            );

            if (hasWrongAnswer) {
                return;
            }
        }
        Engine.showCongratulations(userName);

    }
}
