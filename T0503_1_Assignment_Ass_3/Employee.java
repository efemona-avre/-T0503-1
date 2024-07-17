package T0503_1_Assignment_Ass_3;

import java.util.Scanner;
import java.util.Calendar;

public class Employee {
    private String name;
    private int socialSecurityNumber;
    private int birthdayMonth;
    private int birthdayWeek;
    private double paycheck = 0.0;
    Calendar calendar = Calendar.getInstance();

    void load(Scanner scan) {
        // Input for Name
        System.out.println("Enter Name: ");
        this.name = scan.nextLine();

        // Input for Social Security Number
        while (true) {
            System.out.println("Enter Social Security Number (1-9999): ");
            if (scan.hasNextInt()) {
                int tempInput = scan.nextInt();
                if (tempInput >= 1 && tempInput <= 9999) {
                    this.socialSecurityNumber = tempInput;
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1 and 9999.");
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1 and 9999 or 'q' to quit.");
                }
            }
        }

        // Input for Birthday Month
        while (true) {
            System.out.println("Enter Birthday Month (1-12): ");
            if (scan.hasNextInt()) {
                int tempInput = scan.nextInt();
                if (tempInput >= 1 && tempInput <= 12) {
                    this.birthdayMonth = tempInput;
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1 and 12.");
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1 and 12 or 'q' to quit.");
                }
            }
        }

        // Input for Birthday Week
        while (true) {
            System.out.println("Enter Birthday Week (1-4): ");
            if (scan.hasNextInt()) {
                int tempInput = scan.nextInt();
                if (tempInput >= 1 && tempInput <= 4) {
                    this.birthdayWeek = tempInput;
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1 and 4.");
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1 and 4 or 'q' to quit.");
                }
            }
        }
    }

    public String toString() {
        return String.format("Employee: %s\nSocial Security Number: %d\nPaycheck: $%,.2f", this.name, this.socialSecurityNumber, this.paycheck);
    }

    public double getBonus() {
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // January is 0, December is 11
        int currentWeek = calendar.get(Calendar.WEEK_OF_MONTH);

        if (this.birthdayMonth == currentMonth && this.birthdayWeek == currentWeek) {
            return 100.0;
        }
        return 0.0;
    }

    public void setPaycheck(double paycheck) {
        this.paycheck = paycheck;
    }

    public double getPaycheck() {
        return this.paycheck;
    }
}
