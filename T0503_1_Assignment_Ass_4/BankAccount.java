/*
 * BankAccount.java
 * Efemona Avre
 * 
 * This abstract class represents a general bank account with common functionalities 
 * such as deposit and withdraw. It serves as a base class for specific account types.
 */

package T0503_1_Assignment_Ass_4;

public abstract class BankAccount {
    protected double balance;

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        this.balance += amount;
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) {
        // Check if balance minus amount is less than 0 and return balance or 0 accordingly
        this.balance = this.balance - amount < 0 ? 0 : this.balance - amount;
    }

    // Abstract method to display account details, to be implemented by subclasses
    public abstract void display();
}