package ngohlumdoun.chonnipa.lab4;

import java.util.Scanner;

/**
 * Number Guessing Method Games V2 Program:
 * This program is an advanced iteration of NumberGuessingMethodGames
 * Upon the game's conclusion the player is provided with various options to
 * review their guesses.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 12 Dec 2024 10:41 AM
 */

public class NumberGuessingMethodGamesV2 {
    static Scanner input = new Scanner(System.in);
    static int min;
    static int max;
    static int maxTries;
    static int answer;
    static int userInput;
    static int count;
    static boolean answerCorrectly = false;
    static int[] userGuesses = new int[10];

    public static void main(String[] args) {
        configure();
        playGames();
    }

    static void configure() {
        // Get the minimum and maximum values provided by the user
        System.out.print("Enter the min value:");
        min = input.nextInt();

        System.out.print("Enter the max value:");
        max = input.nextInt();

        // Validate the min and max input
        while (min > max) {
            System.out.println("The max value must be at least equal to the min value");

            System.out.print("Enter the max value:");
            max = input.nextInt();
        }

        // Get the maximum number of tries provided by the user
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();

        // Validate the maximum number of tries input
        while (0 >= maxTries) {
            System.out.println("The maximum number of tries must be greater than 0");

            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
        }
    }

    static void genAnswer() {
        // Generate a random number between the min and max values
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGames() {
        genAnswer();
        answerCorrectly = false;

        count = 0;
        // Display the welcome message
        System.out.println("Welcome to a number guessing game!");

        for (int i = 0; i < maxTries; i++) {

            if (answerCorrectly)
                break;

            // Get the user input number
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            userInput = input.nextInt();

            // Validate the user input between the min and max values
            while (min > userInput || max < userInput) {
                System.out.println("The number must be between " + min + " and " + max);

                System.out.print("Enter an integer between " + min + " and " + max + ":");
                userInput = input.nextInt();
            }

            // Store the user's guesses in an array
            userGuesses[i] = userInput;

            // Check if the user input is the target number
            checkAnswer(userInput);
        }

        if (!answerCorrectly) {
            // Display the number of attempts made by the user
            System.out.println(
                    "You have tried " + count + ((count > 1) ? " times" : " time") + ". You ran out of guesses");
            System.out.println("The answer is " + answer);
        }

        displayGuesesLoop();
        // Ask the user if they want to play again
        System.out.print("Want to play again (Y or y):");
        String userAnswer = input.next();

        // If the user chooses to play again, start a new game
        if (userAnswer.equals("Y") || userAnswer.equals("y")) {
            playGame();
        } else {
            System.out.println("Thank you for playing our games. Bye!");
            System.exit(0);
        }
    }

    static void playGame() {
        playGames();
    }

    static void checkAnswer(int guesse) {

        if (guesse == answer) {
            // Increment the count of attempts made by the user
            count++;
            System.out.println("Congratulations!");
            System.out.println("You have tried " + count + ((count > 1) ? " times" : " time"));

            answerCorrectly = true;

        } else if (userInput > answer) {
            System.out.println("Try a lower number!");
            // Increment the count of attempts made by the user
            count++;
        } else {
            System.out.println("Try a higher number!");
            // Increment the count of attempts made by the user
            count++;
        }
    }

    static void displayAllGuesses() {
        // Display all the user's guesses in reverse order
        for (int i = 0; i < count; i++) {
            System.out.println("Guess " + (i + 1) + ": " + userGuesses[i]);
        }
    }

    static void displaySpecificGuess() {
        // Ask the user to enter a specific guess number
        System.out.print("Enter the guess number:");
        int guessNumber = input.nextInt();
        System.out.println("Guess " + guessNumber + ": " + userGuesses[guessNumber - 1]);

    }

    static void displayGuesesLoop() {
        // Display a menu to ask the user if they want to list all guesses or a specific
        // guess
        while (true) {
            System.out.print(
                    "Enter 'a' to list all guesses, 'g' to list for a specific guess, or any other key to quit:");
            String displayGuessAnswer = input.next();
            if (displayGuessAnswer.equalsIgnoreCase("a")) {
                displayAllGuesses();
            } else if (displayGuessAnswer.equalsIgnoreCase("g")) {
                displaySpecificGuess();
            } else {
                break;
            }
        }
    }
}