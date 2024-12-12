package ngohlumdoun.chonnipa.lab3;

/**
 * Number Guessing Game Program:
 * This simulates a guessing game of which a user guesses a number from 1 to 10.
 * The answer is randomly generated then a user enters a number via the console.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 12 Dec 2024 07:15 PM
 */

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        // Create a Scanner object to get user inputs from the console
        Scanner input = new Scanner(System.in);

        // Generate a random number between 1 and 10 for the target number
        int max = 10;
        int min = 1;
        int answer = min + (int) (Math.random() * ((max - min) + 1));

        // Display the welcome message
        System.out.println("Welcome to a number guessing game!");

        // Accept user inputs and compare with the target number
        // until the user guesses correctly or runs out of attempts
        int count = 1;
        for (int i = 0; i < 5; i++) {

            // Get the user input number
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int userInput = input.nextInt();

            // Check if the user input is the target number
            if (userInput == answer) {
                System.out.println("Congratulations!");
                System.out.print("You have tried " + count + " time");

                // If user made more than one attempt, add "s" after "time" to make it plural.
                if (count > 1)
                    System.out.print("s");

                System.exit(-1);
                ;
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
        input.close();

        // Display the number of attempts made by the user
        System.out.println("You have tried 5 times. You ran out of guesses");
        System.out.println("The answer is " + answer);
    }
}
