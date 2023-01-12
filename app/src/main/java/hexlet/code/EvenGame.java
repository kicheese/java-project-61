package hexlet.code;

import java.util.Scanner;

public class EvenGame {
    public static void start(String userName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        boolean hasWrongAnswer = false;

        for (int i = 0; i < 3 && !hasWrongAnswer; i++) {
            int min = 1;
            int max = 50;
            int randomNumber =  (int) Math.floor(Math.random() * (max - min + 1) + min);

            System.out.println("Question: " + randomNumber);
            String answer = scanner.next();

            System.out.println("Your answer: " + answer);

            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            if (correctAnswer.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
                System.out.printf("Let's try again, %s!", userName);

                hasWrongAnswer = true;
            }
        }

        if (!hasWrongAnswer) {
            System.out.printf("Congratulations, %s!", userName);
        }
    }
}

