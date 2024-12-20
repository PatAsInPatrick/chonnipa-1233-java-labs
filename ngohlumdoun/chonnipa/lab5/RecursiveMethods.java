package ngohlumdoun.chonnipa.lab5;

/**
 * Recursive Methods Program:
 * Implement methods in program RecursiveMethods that implements various
 * recursive methods for array and number operations.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 20 Dec 2024 02:39 AM
 */

public class RecursiveMethods {

    /**
     * Recursively finds the sum of digits in a number.
     * Example: For the number 123, the answer is 1+2+3 = 6
     * 
     * @param number the input number
     * @return sum of digits
     */
    public static int sumOfDigits(int number) {
        int lastDigits = number % 10;
        int remainder = number / 10;
        if (remainder == 0) {
            return lastDigits;
        } else {
            return lastDigits + sumOfDigits(remainder);
        }
    }

    /**
     * Recursively reverses an array between start and end indices.
     * 
     * @param arr   the array to reverse
     * @param start starting index
     * @param end   ending index
     */
    public static void reverseArray(int[] arr, int start, int end) {
        if (start < end) {
            // Swap elements at start and end indices and recursively call the method
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseArray(arr, start + 1, end - 1);
        } else {
            // Print the reversed array
            printArray(arr);
        }
    }

    /**
     * Recursively checks if an array is palindrome.
     * 
     * @param arr   the array to check
     * @param start starting index
     * @param end   ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        } else if (arr[start] != arr[end]) {
            return false;
        } else {
            return isPalindrome(arr, start + 1, end - 1);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Test cases for sumOfDigits method
        System.out.println("Sum of digits in 45: " + sumOfDigits(45));
        System.out.println("Sum of digits in 12345: " + sumOfDigits(12345));

        System.out.println();

        // Test cases for reverseArray method
        int[] forReverse = { 1, 2, 3, 4, 5 };

        System.out.println("Original array:");
        printArray(forReverse);
        System.out.println("Reversed array:");
        reverseArray(forReverse, 0, forReverse.length - 1);

        System.out.println();

        // Test cases for isPalindrome method
        int[] forPalindrome1 = { 1, 2, 3, 2, 1 };
        int[] forPalindrome2 = { 1, 2, 1, 2 };

        // True case
        System.out.println("Testing palindrome:");
        printArray(forPalindrome1);
        System.out.println("Is palindrome: " + isPalindrome(forPalindrome1, 0, forPalindrome1.length - 1));

        System.out.println();

        // False case
        System.out.println("Testing palindrome:");
        printArray(forPalindrome2);
        System.out.println("Is palindrome: " + isPalindrome(forPalindrome2, 0, forPalindrome2.length - 1));
    }

}
