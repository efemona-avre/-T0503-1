
/*
 * Savings.java
 * Efemona Avre
 * 
 * This class represents a savings account which inherits from BankAccount.
 * It includes functionalities specific to savings accounts such as adding interest.
 */

package T0503_1_Assignment_Ass_4;

public class Savings extends BankAccount {
    private double interestRate;
    
    // Named Constants
    private final String CURRENCY = "$";

    // Constructor to initialize balance and interest rate, ensuring balance is non-negative
    public Savings(double balance, double interestRate) {
        this.balance = balance < 0 ? 0 : balance;
        this.interestRate = interestRate;
    }

    // Method to add interest to the balance
    public void addInterest() {
        this.balance = this.balance * (1 + this.interestRate);
    }

    // Overridden method to display the savings account details
    @Override
    public void display() {
        System.out.printf("Account Type: Savings \n"
                + "Balance : %s%,.2f\n\n", this.CURRENCY, this.balance);
    }
}
