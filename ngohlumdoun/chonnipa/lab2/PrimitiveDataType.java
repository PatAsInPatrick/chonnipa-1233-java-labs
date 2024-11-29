package ngohlumdoun.chonnipa.lab2;

/**
 * Primitive Data Type Program:
 * This program converts
 * 
 * The output should be
 * 
 * Student ID : 673040123-3
 * First Name : Chonnipa
 * Byte Value : <value of the number of letters in your first name.>
 * Short Value : <value of your myByte variable multiplied by 21>
 * Int Value : <value of the last six digits of your student ID>
 * Long Value : <value of your student ID without any dashes or spaces>
 * Float Value : <value of 0.xx, where xx is your myByte variable>
 * Double Value : <value of 0.yyyy, where yyyy are the last four digits of your student ID>
 * Char Value : <first letter of your first name>
 * Boolean Value : <true if the last digit of your student ID is odd, and false if it is even>
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 * 
 * Last Updated : 29 Nov 2024 9:57 AM
 */

public class PrimitiveDataType {
    public static void main(String[] args) {

        // Student Information Variables
        String studentNumber = "673040123-3";
        String firstName = "Chonnipa";

        // Clean Student ID to remove spaces and dashes
        String cleanStudentNumber = studentNumber.replace(" ", "").replace("-", "");

        // Primitive Data Type Variables
        byte myByte = (byte) firstName.length();
        short myShort = (short) (myByte * 21);
        int myInt = Integer.parseInt(cleanStudentNumber.substring(4, 10));
        long myLong = Long.parseLong(cleanStudentNumber);
        float myFloat = myByte / 100f;
        double myDouble = Integer.parseInt(cleanStudentNumber.substring(6, 9)) / 1000.0;
        char myChar = firstName.charAt(0);
        boolean myBoolean = cleanStudentNumber.charAt(9) % 2 != 0;

        // Print the converted values
        System.out.println("Student ID : " + studentNumber);
        System.out.println("First Name : " + firstName);
        System.out.println("Byte Value : " + myByte);
        System.out.println("Short Value : " + myShort);
        System.out.println("Int Value : " + myInt);
        System.out.println("Long Value : " + myLong);
        System.out.println("Float Value : " + myFloat);
        System.out.println("Double Value : " + myDouble);
        System.out.println("Char Value : " + myChar);
        System.out.println("Boolean Value : " + myBoolean);
    }
}
