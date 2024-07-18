/**
 * 
 * Employee.java
 * Efemona Avre
 * Assignment 3: T0503-1
 * Represents a Salaried Plus Commission Employee extending the Salaried class.
 * Includes additional details for sales made and commission rate.
 */

package T0503_1_Assignment_Ass_3;

import java.util.Scanner;

public class SalariedPlus extends Salaried {
    private double salesLastWeek;
    private double commissionRate;
    private double commissionEarned;

    // Named constants
    public static final double MIN_WEEKLY_SALES = 0.0;
    public static final double MAX_WEEKLY_SALES = 999999.99;
    public static final double MIN_COMMISSION_RATE = 0.0;
    public static final double MAX_COMMISSION_RATE = 250.0;
    
    /**
     * Loads salaried plus commission employee information from user input.
     * Prompts for weekly salary, sales made, and commission rate.
     * Ensures valid input for each field.
     *
     * @param scan Scanner object to read user input
     */
    @Override
    public void load(Scanner scan) {
        super.load(scan);

        // Input for previous week sales
        while (true) {
            System.out.println("Enter previous sales number (" + MIN_WEEKLY_SALES + "-"+ MAX_WEEKLY_SALES +"): ");
            if (scan.hasNextDouble()) {
                double tempInput = scan.nextDouble();
                if (tempInput >= MIN_WEEKLY_SALES) {
                    this.salesLastWeek = tempInput;
                    scan.nextLine(); // consume the leftover newline
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number >= " + MIN_WEEKLY_SALES );
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a number >= " + MIN_WEEKLY_SALES + " or 'q' to quit.");
                }
            }
        } // end while loop

        // Input for commission rate
        while (true) {
            System.out.println("Enter commission rate ("+ MIN_COMMISSION_RATE +"-"+ MAX_COMMISSION_RATE +"): ");
            if (scan.hasNextDouble()) {
                double tempInput = scan.nextDouble();
                if (tempInput >= MIN_COMMISSION_RATE && tempInput <= MAX_COMMISSION_RATE) {
                    this.commissionRate = tempInput;
                    scan.nextLine(); // consume the leftover newline
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + MIN_COMMISSION_RATE + " and " + MAX_COMMISSION_RATE + ".");
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + MIN_COMMISSION_RATE + " and " + MAX_COMMISSION_RATE + " or 'q' to quit.");
                }
            }
        }  // end loop
    } // end load method

    /**
     * Calculates earnings for a salaried plus commission employee.
     * Includes base salary and commission based on sales made.
     */
    @Override
    public void getEarnings() {
        super.getEarnings();
        this.commissionEarned = this.salesLastWeek * this.commissionRate / 100;
        double totalEarnings = this.commissionEarned + this.getPaycheck();
        super.setPaycheck(totalEarnings);
    } // end getEarnings method

    /**
     * Returns a string representation of the SalariedPlusCommission object.
     * Formats the output to include additional earnings details.
     *
     * @return String representation of the SalariedPlusCommission object
     */
    @Override
    public String toString() {
        return String.format(super.toString() +
                "\nCommission Earned: $%,.2f",
                this.commissionEarned);
    }
}
