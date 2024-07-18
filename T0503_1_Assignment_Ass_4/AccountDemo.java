
/*
 * AccountDemo.java
 * Efemona Avre
 * 
 * This class serves as a demonstration of the bank account functionalities.
 * It creates instances of different account types and performs various operations on them.
 */

package T0503_1_Assignment_Ass_4;

public class AccountDemo {

    public static void main(String[] args) {
        // Create an array to hold bank accounts
        BankAccount[] accounts = new BankAccount[100];

        // Initialize and manipulate Savings account
        accounts[0] = new Savings(1100, .05);
        accounts[0].deposit(100);
        accounts[0].withdraw(200);
        ((Savings) accounts[0]).addInterest();

        // Initialize and manipulate Checking account with negative balance
        accounts[1] = new Checking(-100);
        accounts[1].deposit(50);

        // Initialize and manipulate Checking account with positive balance
        accounts[2] = new Checking(200);
        accounts[2].withdraw(210);
        accounts[2].deposit(100);
        ((Checking) accounts[2]).writeACheck(50);

        // Display account details for all initialized accounts
        for (int i = 0; i < accounts.length && accounts[i] != null; i++) {
            accounts[i].display();
        }
    } // end main
}