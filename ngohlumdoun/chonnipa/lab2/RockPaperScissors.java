package ngohlumdoun.chonnipa.lab2;

import java.util.HashSet;
import java.util.Set;

/**
 * Rock Paper Scissors Program:
 * This program simulates a simple Rock-Paper-Scissors game between two players.
 * The program should accept two arguments, each representing the choice of a
 * player.
 * ------------------------------------
 * The output should be
 * 
 * Player 1 chooses: <player1_choice>
 * Player 2 chooses: <player2_choice>
 * Player 1 wins! / Player 2 wins! / It's a tie!
 * ------------------------------------
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 3 Dec 2024 10:06 PM
 */

public class RockPaperScissors {
    public static void main(String[] args) {

        // Create a set of valid choices to validate the player's choices
        Set<String> validChoices = new HashSet<>();
        validChoices.add("rock");
        validChoices.add("paper");
        validChoices.add("scissors");

        // Check if the number of arguments is two
        if (args.length != 2) {
            System.err.println("Invalid number of arguments. Please provide exactly two arguments.");
            System.exit(-1);
        }

        // Get the player's choices and convert them to lower case
        String player1_choice = args[0].toLowerCase();
        String player2_choice = args[1].toLowerCase();

        // Check if the arguments are valid
        if (validChoices.contains(player1_choice) && validChoices.contains(player2_choice)) {
            System.out.println("Player 1 chooses: " + player1_choice);
            System.out.println("Player 2 chooses: " + player2_choice);

            // Determine the winner based on the rock-paper-scissors rules
            if (player1_choice.equals(player2_choice))
                System.out.println("It's a tie!");

            else if ((player1_choice.equals("rock") && player2_choice.equals("scissors")) ||
                    (player1_choice.equals("scissors") && player2_choice.equals("paper")) ||
                    (player1_choice.equals("paper") && player2_choice.equals("rock"))) {
                System.out.println("Player 1 wins!");

            } else
                System.out.println("Player 2 wins!");
        } else {
            System.err.println("Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissor'");
            System.exit(-1);
        }
    }
}