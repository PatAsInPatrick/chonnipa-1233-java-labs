package ngohlumdoun.chonnipa.lab5;

import java.util.Scanner;

/**
 * Matrix Operations Program:
 * This program helps you work with matrices in two main phases
 * Matrix Creation Phase - where you create your initial matrix
 * Matrix Operations Phase - where you perform various calculations on your
 * matrix
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 26 Dec 2024 01:09 PM
 */

public class MatrixOperations {
    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {
            displayCreationMenu();
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                // For options 1-4, get matrix dimensions
                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: ");
                columns = scanner.nextInt();

                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }

                matrix = new int[rows][columns];
                createMatrix(choice);
            } else if (choice == 5) {
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = scanner.nextInt();

                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }

                matrix = new int[rows][rows];
                createDiagonalMatrix();
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix);

            // Operations menu loop
            boolean continueOperations = true;
            while (continueOperations) {
                displayOperationsMenu();
                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        transposeMatrix();
                        break;
                    case 2:
                        calculateSums();
                        break;
                    case 3:
                        findMinMax();
                        break;
                    case 4:
                        if (rows != columns) {
                            System.out.println("\nMatrix is not square. Cannot display diagonal elements");
                            break;
                        }
                        displayDiagonal();
                        break;
                    case 5:
                        continueOperations = false;
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }
        scanner.close();
    }

    public static void displayCreationMenu() {
        System.out.println("Matrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zero Matrix");
        System.out.println("4. All One Matrix");
        System.out.println("5. Diagonal Matrix");
        System.out.print("Enter your choice: ");
    }

    public static void createMatrix(int choice) {
        // user choose how to create the matrix
        switch (choice) {
            case 1:
                manualInput();
                break;
            case 2:
                randomNumbers();
                break;
            case 3:
                allZeros();
                break;
            case 4:
                allOnes();
                break;
            default:
                System.out.println("Invalid operation choice.");
        }
    }

    public static void createDiagonalMatrix() {
        for (int i = 0; i < rows; i++)
            matrix[i][i] = 1;
    }

    public static void manualInput() {
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = scanner.nextInt();
    }

    public static void randomNumbers() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = (int) (Math.random() * 10);
    }

    public static void allZeros() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = 0;
    }

    public static void allOnes() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = 1;
    }

    public static void displayMatrix(int matrix[][]) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j == 0)
                    // First element, no leading space
                    System.out.printf("%3d", matrix[i][j]);
                else
                    // Subsequent elements, one space in front
                    System.out.printf(" %3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void displayOperationsMenu() {
        System.out.println("\nMatrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void transposeMatrix() {
        int transpose[][] = new int[columns][rows];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                transpose[j][i] = matrix[i][j];

        System.out.println("\nTransposed Matrix:");

        // display the transposed matrix
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (j == 0)
                    // First element, no leading space
                    System.out.printf("%3d", transpose[i][j]);
                else
                    // Subsequent elements, one space in front
                    System.out.printf(" %3d", transpose[i][j]);
            }
            System.out.println();
        }
    }

    public static void calculateSums() {
        int rowSums[] = new int[rows];
        int columnSums[] = new int[columns];

        System.out.println("\nRows sums:");

        // sum of all rows
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                rowSums[i] += matrix[i][j];
            System.out.println("Row " + (i + 1) + " sum: " + rowSums[i]);
        }

        System.out.println();

        // sum of all columns
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++)
                columnSums[j] += matrix[i][j];
            System.out.println("column " + (j + 1) + " sum: " + columnSums[j]);
        }
    }

    public static void findMinMax() {
        int min = matrix[0][0];
        int max = matrix[0][0];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < min)
                    min = matrix[i][j];
                if (matrix[i][j] > max)
                    max = matrix[i][j];
            }

        System.out.println("\nMinimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    public static void displayDiagonal() {
        System.out.println("\nDiagonal elements:");
        for (int i = 0; i < rows; i++)
            System.out.print(matrix[i][i] + "  ");

        System.out.println();
    }
}
