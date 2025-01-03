package ngohlumdoun.chonnipa.lab6;

import java.util.Scanner;

/**
 * Number Guessing OOP Game V2 Program:
 * Enhance the program from Number Guessing OOP Game to check for robustness by
 * handling invalid inputs.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 3 Jan 2025 10:30 AM
 */

public class NumberGuessingOOPGameV2 {
    public static Scanner input = new Scanner(System.in);
    private GuessGameV2 game;

    public void configure() {

        // Get the minimum and maximum values provided by the user
        System.out.print("Enter the min value:");
        int min = input.nextInt();
        System.out.print("Enter the max value:");
        int max = input.nextInt();

        this.game = new GuessGameV2(min, max);

        this.game.configureGame(min, max);

        // Get the maximum number of tries provided by the user
        System.out.print("Enter the maximum number of tries:");
        int maxTries = input.nextInt();
        
        this.game = new GuessGameV2(game.getMin(), game.getMax(), maxTries);

        this.game.configureGame(game.getMin(), game.getMax(), maxTries);
    }

    public void playGames() {
        boolean playAgain;
        do {
            System.out.println(game.toString());
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");
            System.out.print("Do you want to play again (y/n): ");
            playAgain = input.next().equalsIgnoreCase("y");

            if (playAgain)
                configure();
            else
                System.out.println("Thank you for playing the Number Guessing Game V2!");

        } while (playAgain);
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        program.configure();
        program.playGames();
    }
}
