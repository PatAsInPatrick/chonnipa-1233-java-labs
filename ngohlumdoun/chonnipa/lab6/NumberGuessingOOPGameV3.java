package ngohlumdoun.chonnipa.lab6;

import java.util.Scanner;

/**
 * Number Guessing OOP Game V3 Program:
 * Enhance the program from Number Guessing OOP Game V2, which incorporates
 * record-keeping using arrays.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 23 Jan 2025 04:30 PM
 */

public class NumberGuessingOOPGameV3 {
    public static Scanner input = new Scanner(System.in);
    private GuessGameV3 game;

    public void configure() {

        // Get the minimum and maximum values provided by the user
        System.out.print("Enter the min value:");
        int min = input.nextInt();
        System.out.print("Enter the max value:");
        int max = input.nextInt();

        this.game = new GuessGameV3(min, max);

        this.game.configureGame(min, max);

        // Get the maximum number of tries provided by the user
        System.out.print("Enter the maximum number of tries:");
        int maxTries = input.nextInt();

        this.game = new GuessGameV3(game.getMin(), game.getMax(), maxTries);

        this.game.configureGame(game.getMin(), game.getMax(), maxTries);
    }

    public void playGames() {
        int userInput;
        game.playSingleGame();

        do {
            System.out.println("Do you want to:");
            System.out.println("1. Play again");
            System.out.println("2. View game records");
            System.out.println("3. Quit");
            userInput = input.nextInt();

            switch (userInput) {
                case 1:
                    configure();
                    game.playSingleGame();
                    break;

                case 2:
                    viewRecords();
                    continue;

                case 3:
                    System.out.println("Thank you for playing Number Guessing Game V3!");
                    input.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid menu option. Please try again.");
                    break;
            }

        } while (true);
    }

    public void viewRecords() {
        int userInput;
        GuessGameV3[] gameRecords = GuessGameV3.getGameRecords();
        int recordCount = GuessGameV3.getRecordCount();

        System.out.println("View:");
        System.out.println("1. Complete Records");
        System.out.println("2. Specific Game Record");
        userInput = input.nextInt();

        switch (userInput) {
            case 1:
                // display only the actual game records
                for (int i = 0; i < recordCount; i++)
                    System.out.println("Game " + (i + 1) + ": " + gameRecords[i].getGameLog());
                break;

            case 2:
                // display a specific game record
                System.out.print("Enter the game number to view: ");
                int gameNumber = input.nextInt();

                if (gameNumber > 0 && gameNumber <= GuessGameV3.getRecordCount())
                    System.out.println(gameRecords[gameNumber - 1].getGameLog());
                break;

            default:
                System.out.println("Invalid menu option. Please try again.");
                break;
        }
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3();
        program.configure();
        program.playGames();
    }
}
