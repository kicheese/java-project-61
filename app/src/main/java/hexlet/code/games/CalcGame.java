package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {
    private static String getRandomSign() {
        int random = Engine.getRandomNumber(1, 3);

        switch (random) {
            case 1: return "*";
            case 2: return "+";
            default: return "-";
        }
    }

    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the result of the expression?");

        for (int i = 0; i < Engine.roundCount; i++) {
            int firstNumber = Engine.getRandomNumber(1, 50);
            int secondNumber = Engine.getRandomNumber(1, 50);

            String sign = getRandomSign();

            int result;

            if (sign.equals("*")) {
                result = firstNumber * secondNumber;
            } else if (sign.equals("+")) {
                result = firstNumber + secondNumber;
            } else {
                result = firstNumber - secondNumber;
            }

            String expression = String.format("%s %s %s", firstNumber, sign, secondNumber);

            Engine.showQuestion(expression);

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
