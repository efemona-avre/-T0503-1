/**
 * 
 * Employee.java
 * Efemona Avre
 * Assignment 3: T0503-1
 * Represents a Salaried Employee extending the Employee class.
 * Includes weekly fixed salary.
 */
package T0503_1_Assignment_Ass_3;

import java.util.Scanner;

public class Salaried extends Employee {
    private double weeklySalary;

    // Named Constants
    public static final double MIN_WEEKLY_SALARY = 0.0;
    public static final double MAX_WEEKLY_SALARY = 9999.9;
    
    /**
     * Loads salaried employee information from user input.
     * Prompts for weekly salary.
     * Ensures valid input for each field.
     *
     * @param scan Scanner object to read user input
     */
    void load(Scanner scan) {
        super.load(scan);
        // Input for weekly salary
        while (true) {
            System.out.println("Enter weekly Salary (" + MIN_WEEKLY_SALARY + "-" + MAX_WEEKLY_SALARY + "): ");
            if (scan.hasNextDouble()) {
                double tempInput = scan.nextDouble();
                if (tempInput >= MIN_WEEKLY_SALARY && tempInput <= MAX_WEEKLY_SALARY) {
                    this.weeklySalary = tempInput;
                    scan.nextLine(); // consume the leftover newline
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + MIN_WEEKLY_SALARY + " and " + MAX_WEEKLY_SALARY + ".");
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a valid number or 'q' to quit.");
                }
            }
        }
    } // end load method

    /**
     * Calculates earnings for a salaried employee.
     * Returns the fixed weekly salary.
     */
    @Override
    public void getEarnings() {
        double totalEarnings = this.weeklySalary + this.getBonus();
        super.setPaycheck(totalEarnings);
    }

    /**
     * Returns a string representation of the Salaried object.
     * Formats the output to include additional earnings details.
     *
     * @return String representation of the Salaried object
     */
    @Override
    public String toString() {
        return String.format(super.toString() +
                "\n-------------------\n" +
                "Standard Earnings: $%,.2f\n" +
                "Bonus: $%,.2f\n" +
                "Paycheck Total: $%,.2f",
                this.weeklySalary,
                this.getBonus(),
                this.getPaycheck());
    }
}
