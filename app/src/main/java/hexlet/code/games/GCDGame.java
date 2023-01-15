package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GCDGame {
    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < Engine.roundCount; i++) {
            int firstNumber = Engine.getRandomNumber(1, 20);
            int secondNumber = Engine.getRandomNumber(1, 20);

            int divider = Math.min(firstNumber, secondNumber);

            int result = divider;

            while (firstNumber % divider != 0 || secondNumber % divider != 0) {
                divider--;
                result = divider;
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
