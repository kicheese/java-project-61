package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class EvenGame {
    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < Engine.getRoundCount(); i++) {
            var start = 1;
            var end = 50;

            int randomNumber =  Engine.getRandomNumber(start, end);

            Engine.showQuestion(Integer.toString(randomNumber));
            String answer = scanner.next();

            Engine.showAnswer(answer);

            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            boolean hasWrongAnswer = Engine.checkCorrectAnswerAndShowMessage(correctAnswer, answer, userName);

            if (hasWrongAnswer) {
                return;
            }
        }
        Engine.showCongratulations(userName);
    }
}

