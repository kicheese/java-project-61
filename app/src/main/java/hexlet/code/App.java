package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");

        int currentGame = Integer.parseInt(scanner.next());

        System.out.println("Your choice: " + currentGame);

        if (currentGame == 0) {
            return;
        }

        String userName = Cli.toKnowUserName();

        switch (currentGame) {
            case 2: EvenGame.start(userName);
            break;
            default: return;
        }

        scanner.close();
    }
}
