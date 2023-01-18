package hexlet.code;

public class Engine {
    private static final int ROUND_COUNT = 3;

    public static int getRandomNumber(int min,  int max) {
        return   (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static void showQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static void showAnswer(String answer) {
        System.out.println("Your answer: " + answer);
    }

    public static boolean checkCorrectAnswerAndShowMessage(String correctAnswer, String answer, String userName) {
        if (correctAnswer.equals(answer)) {
            System.out.println("Correct!");

            return false;
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", answer, correctAnswer);
            System.out.printf("Let's try again, %s!", userName);

            return true;
        }
    }

    public static int getRoundCount() {
        return ROUND_COUNT;
    }

    public static void showCongratulations(String userName) {
        System.out.printf("Congratulations, %s!", userName);
    }
}
