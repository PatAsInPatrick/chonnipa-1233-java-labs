/**
 * The Dealer Program:
 * This program accepts three arguments then processes
 * and displays dealer information.
 * The output shoukd be
 * Dealer's name : <dealer_name>.
 * Numbre of clients : <num_clients>
 * Gender : <dealer_gender>
 * 
 * Author: Chonnipa Ngohlumdoun
 * ID : 673040123-3
 * Sec : 2
 */

package ngohlumdoun.chonnipa.lab2;

public class Dealer {
    public static void main(String[] args) {
        String dealer_name = args[0];
        int num_clients = Integer.parseInt(args[1]);
        String dealer_gender = args[2];
        
        System.err.println("Invalid number of arguments. Please provide exactly three arguments.");

        System.out.println("Dealer's name : " + dealer_name);
        System.out.println("Number of clients : " + num_clients);
        System.out.println("Gender : " + dealer_gender);
    }
}