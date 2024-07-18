/**
 * Employee.java
 * Efemona Avre
 * Assignment 3: T0503-1
 * Represents a generic Employee with basic information and paycheck details.
 */

package T0503_1_Assignment_Ass_3;

import java.util.Calendar;
import java.util.Scanner;

public abstract class Employee {
    private String name;
    private String socialSecurityNumber;
    private int birthdayMonth;
    private int birthdayWeek;
    private double paycheck = 0.0;

    // Named constants
    public static final int SSN_LENGTH = 9;
    public static final int MIN_BIRTHDAY_MONTH = 1;
    public static final int MAX_BIRTHDAY_MONTH = 12;
    public static final int MIN_BIRTHDAY_WEEK = 1;
    public static final int MAX_BIRTHDAY_WEEK = 4;
    public static final double BONUS_AMOUNT = 100.0;

    
    /**
     * Loads employee information from user input.
     * Prompts for name, social security number, birthday month, and birthday week.
     * Ensures valid input for each field.
     *
     * @param scan Scanner object to read user input
     */
    void load(Scanner scan) {
        // Input for Name
        System.out.println("Enter Name: ");
        this.name = scan.nextLine();

        // Input for Social Security Number
        while (true) {
            System.out.println("Enter Social Security Number (" + SSN_LENGTH + " digits) or 'q' to quit: ");
            String input = scan.next();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thanks and goodbye!");
                return;
            }
            if (input.matches("\\d{" + SSN_LENGTH + "}")) {
                this.socialSecurityNumber = input;
                break;
            } else {
                System.out.println("Invalid entry. Please enter a " + SSN_LENGTH + "-digit Social Security Number or 'q' to quit.");
            }
        }

        // Input for Birthday Month
        while (true) {
            System.out.println("Enter Birthday Month (" + MIN_BIRTHDAY_MONTH + "-" + MAX_BIRTHDAY_MONTH + ") or 'q' to quit: ");
            String input = scan.next();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thanks and goodbye!");
                return;
            }
            try {
                int tempInput = Integer.parseInt(input);
                if (tempInput >= MIN_BIRTHDAY_MONTH && tempInput <= MAX_BIRTHDAY_MONTH) {
                    this.birthdayMonth = tempInput;
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + MIN_BIRTHDAY_MONTH + " and " + MAX_BIRTHDAY_MONTH + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a valid number or 'q' to quit.");
            }
        }

        // Input for Birthday Week
        while (true) {
            System.out.println("Enter Birthday Week (" + MIN_BIRTHDAY_WEEK + "-" + MAX_BIRTHDAY_WEEK + ") or 'q' to quit: ");
            String input = scan.next();
            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thanks and goodbye!");
                return;
            }
            try {
                int tempInput = Integer.parseInt(input);
                if (tempInput >= MIN_BIRTHDAY_WEEK && tempInput <= MAX_BIRTHDAY_WEEK) {
                    this.birthdayWeek = tempInput;
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + MIN_BIRTHDAY_WEEK + " and " + MAX_BIRTHDAY_WEEK + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a valid number or 'q' to quit.");
            }
        }

        scan.nextLine(); // Consume the newline character
    }

    /**
     * Abstract method to be implemented by subclasses to calculate earnings.
     */
    public abstract void getEarnings();
    
    /**
     * Returns a string representation of the Employee object.
     * Formats the output to include name, social security number, and paycheck.
     *
     * @return String representation of the Employee object
     */
    @Override
    public String toString() {
        String formattedSSN = socialSecurityNumber.substring(0, 3) + "-" + 
                              socialSecurityNumber.substring(3, 5) + "-" + 
                              socialSecurityNumber.substring(5, 9);
        return String.format("Employee: %s\nSocial Security Number: %s", this.name, formattedSSN);
    }
    
    /**
     * Calculates and returns the birthday bonus if applicable.
     * Compares the employee's birthday with the current date.
     *
     * @return Bonus amount if it's the employee's birthday week, otherwise 0.0
     */
    public double getBonus() {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // January is 0, December is 11
        int currentWeek = calendar.get(Calendar.WEEK_OF_MONTH);

        if (this.birthdayMonth == currentMonth && this.birthdayWeek == currentWeek) {
            return BONUS_AMOUNT;
        } else {
            return 0.0;
        }
    }// ends getBonus method
    
    /**
     * Retrieves the current paycheck amount for the employee.
     *
     * @return The current paycheck amount
     */
    public double getPaycheck() {
        return paycheck;
    }
    
    /**
     * Sets the paycheck amount for the employee.
     * Limits the paycheck to a maximum of MAX_PAYCHECK.
     *
     * @param paycheck The paycheck amount to set
     */
    public void setPaycheck(double paycheck) {
        this.paycheck = paycheck;
    }
}
