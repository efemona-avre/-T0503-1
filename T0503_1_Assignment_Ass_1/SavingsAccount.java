package T0503_1_Assignment_Ass_1;
/** SavingsAccount.java
 * Efemona Avre
 * Assignment 1: Aggregation and Compensation - Saving Account Comparison (Graded)
 * 
 * This is the SavingAccount Class
 * */

public class SavingsAccount {
	private final int ACCOUNT_NUMBER;
	private double balance;
	private double annualInterestRate = 0.0;
	
	public SavingsAccount(int account_number, double balance) {
		this.ACCOUNT_NUMBER = account_number;
		this.balance = balance;
		
	}
	
	public int getAccountNumber() {
		return this.ACCOUNT_NUMBER;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void addMonthlyInterest() {
		this.balance += (this.balance * this.annualInterestRate /12);
	}
	
	
}
