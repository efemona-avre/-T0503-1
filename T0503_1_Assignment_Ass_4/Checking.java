
/*
 * Checking.java
 * Efemona Avre
 * 
 * This class represents a checking account which inherits from BankAccount.
 * It includes functionalities specific to checking accounts such as writing checks.
 */

package T0503_1_Assignment_Ass_4;

public class Checking extends BankAccount {
    private final String CURRENCY = "$";

    // Constructor to initialize balance, ensuring it is non-negative
    public Checking(double balance) {
        this.balance = balance < 0 ? 0 : balance;
    }

    // Method to write a check, deducting the amount plus a fee from the balance
    public void writeACheck(double amount) {
        this.balance = this.balance - amount - 1 < 0 ? this.balance : this.balance - amount - 1;
    }

    // Overridden method to display the checking account details
    @Override
    public void display() {
        System.out.printf("Account Type: Checking \n"
                + "Balance : %s%,.2f\n\n", this.CURRENCY, this.balance);
    }
}
