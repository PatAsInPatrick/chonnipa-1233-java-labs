package ngohlumdoun.chonnipa.lab6;

import java.util.Scanner;

public class GuessGame {
    private int min;
    private int max;
    private int maxTries;
    private int answer;
    private int attempts;
    public static Scanner input = new Scanner(System.in);

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public GuessGame() {
        this.min = 0;
        this.max = 100;
        this.maxTries = 10;
        this.answer = 0;
        this.attempts = 0;
    }

    public GuessGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
        this.answer = 0;
        this.attempts = 0;
    }

    public void configureGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
        this.answer = 0;
        this.attempts = 0;
    }

    public void generateAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    public boolean playSingleGame() {
        generateAnswer();
        boolean answerCorrectly = false;

        attempts = 0;
        // Display the welcome message
        System.out.println("Welcome to a number guessing game!");

        for (int i = 0; i < maxTries; i++) {
            // Get the user input number
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int userInput = input.nextInt();

            // Validate the user input between the min and max values
            while (min > userInput || max < userInput) {
                System.out.println("The number must be between " + min + " and " + max);
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                userInput = input.nextInt();
            }

            // Check if the user input is the target number
            if (userInput == answer) {
                // Increment the count of attempts made by the user
                attempts++;
                System.out.println("Congratulations! You've guessed the number in " + attempts
                        + ((attempts > 1) ? " attempts" : " attempt"));

                answerCorrectly = true;
                break;

            } else if (userInput > answer) {
                System.out.println("Try a lower number!");
                // Increment the count of attempts made by the user
                attempts++;
            } else {
                System.out.println("Try a higher number!");
                // Increment the count of attempts made by the user
                attempts++;
            }
        }

        if (!answerCorrectly)
            // Display the number of attempts made by the user
            System.out.println("Sorry, you've used all your attempts. The correct answer was: " + answer);

        return answerCorrectly;
    }
}