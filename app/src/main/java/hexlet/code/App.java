package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        int currentGame = Integer.parseInt(scanner.next());

        System.out.println("Your choice: " + currentGame);

        final int gamesNumberNull = 0;
        final int gamesNumberTwo = 2;
        final int gamesNumberThree = 3;
        final int gamesNumberFour = 4;
        final int gamesNumberFive = 5;
        final int gamesNumberSix = 6;

        if (currentGame == gamesNumberNull) {
            return;
        }

        String userName = Cli.toKnowUserName();

        switch (currentGame) {
            case gamesNumberTwo: EvenGame.start(userName);
            break;
            case gamesNumberThree: CalcGame.start(userName);
            break;
            case gamesNumberFour: GCDGame.start(userName);
            break;
            case gamesNumberFive: ProgressionGame.start(userName);
            break;
            case gamesNumberSix: PrimeGame.start(userName);
            break;
            default: return;
        }

        scanner.close();
    }
}
