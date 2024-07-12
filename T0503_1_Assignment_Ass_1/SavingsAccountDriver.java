package T0503_1_Assignment_Ass_1;

/** SavingsAccountDriver.java
 * Efemona Avre
 * Assignment 1: Aggregation and Compensation - Saving Account Comparison (Graded)
 * 
 * This is the SavingAccount Class Driver
 * */

public class SavingsAccountDriver {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(10002, 2000.0); // Savings account 1
        SavingsAccount saver2 = new SavingsAccount(10003, 3000.0); // Savings account 2
        double annualInterestRate = 0.05;
        saver1.setAnnualInterestRate(annualInterestRate); // Set the annual interest rate.
        saver2.setAnnualInterestRate(annualInterestRate); // Set the annual interest rate.

        // Print an output that displays the month number and the account number and the balance for each of the two accounts.
        System.out.println("Monthly balances for one year with 0.05 annual interest:");
        System.out.println("Month Account #   Balance   Account #   Balance");
        System.out.println("----- ---------   -------   ---------   -------");
        System.out.printf("%2d    %8d    $%,8.2f    %8d    $%,8.2f\n",
                0, saver1.getAccountNumber(), saver1.getBalance(), saver2.getAccountNumber(), saver2.getBalance());

        for (int i = 1; i <= 12; i++) {
            saver1.addMonthlyInterest(); // Adds interest to account balance
            saver2.addMonthlyInterest(); // Adds interest to account balance
            System.out.printf("%2d    %8d    $%,8.2f    %8d    $%,8.2f\n",
                    i, saver1.getAccountNumber(), saver1.getBalance(), saver2.getAccountNumber(), saver2.getBalance());
        }

        double combinedBalance = saver1.getBalance() + saver2.getBalance();
        System.out.printf("Final balance of both accounts combined: $%,.2f\n", combinedBalance);
    }
}
