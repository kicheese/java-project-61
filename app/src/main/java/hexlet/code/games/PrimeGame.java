package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class PrimeGame {
    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int i = 0; i < Engine.getRoundCount(); i++) {
            int start = 1;
            int end = 20;

            int randomNumber = Engine.getRandomNumber(start, end);

            boolean isSimpleNumber = true;

            if (randomNumber == 1) {
                isSimpleNumber = false;
            } else {
                for (int j = 2; j < randomNumber; j++) {

                    if (randomNumber % j == 0) {
                        isSimpleNumber = false;
                        break;
                    }
                }
            }

            String correctAnswer = isSimpleNumber ?  "yes" : "no";

            Engine.showQuestion(Integer.toString(randomNumber));

            String answer = scanner.next();
            Engine.showAnswer(answer);

            boolean hasWrongAnswer = Engine.checkCorrectAnswerAndShowMessage(
                    correctAnswer, answer, userName
            );

            if (hasWrongAnswer) {
                return;
            }
        }
        Engine.showCongratulations(userName);
    }
}
