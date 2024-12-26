package ngohlumdoun.chonnipa.lab5;

import java.util.Arrays;

/**
 * Number Analyzer Program:
 * Implement methods in a Java program named NumberAnalyzer that implements
 * various statistical methods to analyze arrays of numbers.
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 20 Dec 2024 02:39 AM
 */

public class NumberAnalyzer {

    /**
     * Finds both the minimum and maximum values in an array.
     * 
     * @param numbers the array to analyze
     * @return an array of two elements where index 0 is minimum and index 1 is
     *         maximum
     */
    public static int[] findMinMax(int[] numbers) {
        int[] newArray = numbers.clone();
        int[] answer = new int[newArray.length];
        Arrays.sort(newArray);
        answer[0] = newArray[0];
        answer[1] = newArray[newArray.length - 1];
        return answer;
    }

    /**
     * Recurively Calculates the running average of numbers up to each position.
     * For example: input [1,2,3] returns [1.0, 1.5, 2.0]
     * 
     * @param numbers the input array
     * @return array of running averages
     */
    public static double[] calculateRunningAverages(int[] numbers) {
        double[] runningAverages = new double[5];
        double sum = 0;
        for (int i = 0; i < runningAverages.length; i++) {
            sum += numbers[i];
            runningAverages[i] = sum / (double) (i + 1);
        }
        return runningAverages;
    }

    /**
     * Checks if the array is sorted in ascending order.
     * 
     * @param numbers the array to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(int[] numbers) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);
        return Arrays.equals(numbers, sorted);
    }

    public static void printArrayCurlyBrackets(int[] arr) {
        String newArray = Arrays.toString(arr);
        System.out.println(newArray
                .replace("[", "{")
                .replace("]", "}"));
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] testingArray1 = { 4, 2, 7, 1, 9 };
        int[] testingArray2 = { 1, 2, 3, 4, 5 };

        System.out.print("Testing with array: ");
        printArrayCurlyBrackets(testingArray1);

        // Test for findMinMax method
        System.out.println("Minimum value: " + findMinMax(testingArray1)[0]);
        System.out.println("Maximum value: " + findMinMax(testingArray1)[1]);

        System.out.println();

        // Test for calculateRunningAverages method
        System.out.println("Running averages:");
        for (int i = 0; i < testingArray1.length; i++) {
            System.out
                    .println("Position " + i + ": " +
                            String.format("%.2f", calculateRunningAverages(testingArray1)[i]));
        }

        System.out.println();

        // Test for isSorted method
        System.out.println("Testing if arrays are sorted:");

        // True case
        printArray(testingArray1);
        System.out.println("numbers1 is sorted: " + isSorted(testingArray1));

        // False case
        printArray(testingArray2);
        System.out.println("numbers2 is sorted: " + isSorted(testingArray2));

    }
}
