package ngohlumdoun.chonnipa.lab6;

import java.util.Scanner;

/**
 * Number Guessing OOP Game Program:
 * This program will replicate the functionality of Lab 4 Problem 1:
 * NumberGuessingMethodGames but implemented using object-oriented programming
 * principles. Follow the interaction style and print formats of Lab 4.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 27 Dec 2024 10:48 AM
 */

public class NumberGuessingOOPGame {
    public static Scanner input = new Scanner(System.in);
    private GuessGame game;

    public void configure() {
        // Get the minimum and maximum values provided by the user
        System.out.print("Enter the min value:");
        int min = input.nextInt();
        System.out.print("Enter the max value:");
        int max = input.nextInt();

        // Validate the min and max input
        while (min > max) {
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }

        // Get the maximum number of tries provided by the user
        System.out.print("Enter the maximum number of tries:");
        int maxTries = input.nextInt();

        // Validate the maximum number of tries input
        while (0 >= maxTries) {
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
        }

        this.game = new GuessGame(min, max, maxTries);
    }

    public void playGames() {
        boolean playAgain;
        do {
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");
            System.out.print("Do you want to play again (y/n): ");
            playAgain = input.next().equalsIgnoreCase("y");

            if (playAgain)
                configure();

        } while (playAgain);
    }

    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure();
        program.playGames();
    }
}
