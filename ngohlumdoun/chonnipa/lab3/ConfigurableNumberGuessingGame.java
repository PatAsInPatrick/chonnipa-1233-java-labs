package ngohlumdoun.chonnipa.lab3;

/**
 * Configurable Number Guessing Game Program:
 * This simulates a guessing game of which a user guesses a number from min to max values provided by the user.
 * The answer is randomly generated then a user enters a number via the console.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 6 Dec 2024 11:31 AM
 */

import java.util.Scanner;

public class ConfigurableNumberGuessingGame {
    public static void main(String[] args) {

        // Create a Scanner object to get user inputs from the console
        Scanner input = new Scanner(System.in);

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

        // Generate a random number between the min and max values as the answer
        int answer = min + (int) (Math.random() * ((max - min) + 1));

        // Get the maximum number of tries provided by the user
        System.out.print("Enter the maximun number of tries:");
        int maxTries = input.nextInt();

        // Validate the maximum number of tries input
        while (0 >= maxTries) {
            System.out.println("The maximum number of tries must be greater than 0");

            System.out.print("Enter the maximun number of tries:");
            maxTries = input.nextInt();
        }

        // Display the welcome message
        System.out.println("Welcome to a number guessing game!");

        // Accept user inputs and compare with the target number
        // until the user guesses correctly or runs out of attempts
        int count = 1;
        for (int i = 0; i < maxTries; i++) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");

            // Get the user input number
            int userInput = input.nextInt();

            // Check if the user input is the target number
            if (userInput == answer) {
                System.out.println("Congratulations!");
                System.out.print("You have tried " + count + " time");

                // If user made more than one attempt, add "s" after "time" to make it plural.
                if (count > 1)
                    System.out.print("s");

                System.exit(-1);
            } else if (userInput > answer) {
                System.out.println("Try a lower number!");
            } else {
                System.out.println("Try a higher number!");
            }

            // Increment the count of attempts made by the user
            count++;
        }
        input.close();

        // Display the number of attempts made by the user
        System.out.println("You have tried " + count + " times. You ran out of guesses");
        System.out.println("The answer is " + answer);
    }
}
