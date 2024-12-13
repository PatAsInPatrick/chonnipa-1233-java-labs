package ngohlumdoun.chonnipa.lab4;

import java.util.Scanner;

/**
 * Number Guessing Method Games Program:
 * This simulates a guessing game of which a user guesses a number from min to
 * max values provided by the user.
 * The answer is randomly generated then a user enters a number via the console.
 * After the game ends, the program gives an option to play again or not
 * (All use methods)
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 12 Dec 2024 10:41 AM
 */

public class NumberGuessingMethodGames {
    static Scanner input = new Scanner(System.in);
    static int min;
    static int max;
    static int maxTries;
    static int answer;
    static int userInput;
    static int count;
    static boolean answerCorrectly = false;

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

            if (answerCorrectly) break;

            // Get the user input number
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            userInput = input.nextInt();

            // Validate the user input between the min and max values
            while (min > userInput || max < userInput) {
                System.out.println("The number must be between " + min + " and " + max);

                System.out.print("Enter an integer between " + min + " and " + max + ":");
                userInput = input.nextInt();
            }

            // Check if the user input is the target number
            checkAnswer(userInput);
        }

        if (!answerCorrectly) {
            // Display the number of attempts made by the user
            System.out.print("You have tried " + count + " time");

            // If user made more than one attempt, add "s" after "time" to make it plural.
            if (count > 1)
                System.out.print("s");

            System.out.println(". You ran out of guesses");
            System.out.print("The answer is " + answer);
        }

        // Ask the user if they want to play again
        System.out.print("\nWant to play again (Y or y):");
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
            System.out.print("You have tried " + count + " time");

            // If user made more than one attempt, add "s" after "time" to make it plural.
            if (count > 1)
                System.out.print("s");

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

}