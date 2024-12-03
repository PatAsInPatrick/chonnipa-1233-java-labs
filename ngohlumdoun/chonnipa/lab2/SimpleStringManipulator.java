package ngohlumdoun.chonnipa.lab2;

import java.util.HashSet;
import java.util.Set;

/**
 * Simple String Manipulator Program:
 * This program accepts exactly two string arguments
 * and concatenate the modified first string and the modified second string.
 * 
 * 1. If the first string starts with a vowel (a, e, i, o, u, case-insensitive),
 * convert the first character to uppercase.
 * 
 * 2. If the second string ends with a consonant (any letter that's not a vowel,
 * case-insensitive),
 * convert the last character to uppercase.
 * ------------------------------------
 * The output should be
 * 
 * First String: Apple
 * Second String: banana
 * Resulting String: Applebanan
 * 
 * First String: bat
 * Second String: man
 * Resulting String: batmaN
 * 
 * First String: apple
 * Second String: orange
 * Resulting String: Appleorange
 * ------------------------------------
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 3 Dec 2024 10:22 PM
 */

public class SimpleStringManipulator {
    public static void main(String[] args) {

        // Check if the number of arguments is two
        if (args.length != 2) {
            System.err.println("Invalid number of arguments. Please provide exactly 2 arguments.");
            System.exit(-1);
        }

        // Create a set of vowels
        Set<String> vowels = new HashSet<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        // Display the input strings
        System.out.println("First String: " + args[0]);
        System.out.println("Second String: " + args[1]);

        // Extract the first and last letters of the first and second strings,
        // and convert them to lowercase respectively, if necessary.
        String firstString = args[0];
        String secondString = args[1];
        String firstStringFirstLetter = firstString.substring(0, 1).toLowerCase();
        String secondStringLastLetter = secondString.substring(secondString.length() - 1).toLowerCase();

        // Modify the first string as per the given rules
        if (vowels.contains(firstStringFirstLetter))
            firstString = firstStringFirstLetter.toUpperCase() + firstString.substring(1);
        else
            firstString = firstStringFirstLetter.toLowerCase() + firstString.substring(1);

        // Modify the second string as per the given rules
        if (vowels.contains(secondStringLastLetter))
            secondString = secondString.substring(0, secondString.length() - 1) + secondStringLastLetter.toLowerCase();
        else
            secondString = secondString.substring(0, secondString.length() - 1) + secondStringLastLetter.toUpperCase();

        // Concatenate the modified first string and the modified second string
        String resultingString = firstString + secondString;
        System.out.println("Resulting String: " + resultingString);
    }
}
