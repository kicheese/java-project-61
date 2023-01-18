package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {
    private static String getRandomSign() {
        final int randomNumberStart = 1;
        final int randomNumberEnd = 3;

        int random = Engine.getRandomNumber(randomNumberStart, randomNumberEnd);

        switch (random) {
            case 1: return "*";
            case 2: return "+";
            default: return "-";
        }
    }

    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the result of the expression?");

        for (int i = 0; i < Engine.getRoundCount(); i++) {
            final int startRandoms = 1;
            final int endRandoms = 50;

            int firstNumber = Engine.getRandomNumber(startRandoms, endRandoms);
            int secondNumber = Engine.getRandomNumber(startRandoms, endRandoms);

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
