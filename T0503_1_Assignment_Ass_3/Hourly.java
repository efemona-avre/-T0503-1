package T0503_1_Assignment_Ass_3;

import java.util.Scanner;

public class Hourly extends Employee {
	private double hourlyPay;
    private double hoursWorked;
    private double overtimeHours;

    // Named constants
    public static final double MIN_HOURLY_PAY = 28.0;
    public static final double MAX_HOURLY_PAY = 99.99;
    public static final int MAX_HOURS_WORKED = 40;
    public static final double OVERTIME_RATE = 1.5;

    void load(Scanner scan) {
        super.load(scan);

        // Input for hourly pay
        while (true) {
            System.out.println("Enter Hourly rate number (" + MIN_HOURLY_PAY + " - " + MAX_HOURLY_PAY + "): ");
            if (scan.hasNextDouble()) {
                double tempInput = scan.nextDouble();
                if (tempInput >= MIN_HOURLY_PAY && tempInput <= MAX_HOURLY_PAY) {
                    this.hourlyPay = tempInput;
                    scan.nextLine(); // consume the leftover newline
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + MIN_HOURLY_PAY + " and " + MAX_HOURLY_PAY);
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + MIN_HOURLY_PAY + " and " + MAX_HOURLY_PAY + " or 'q' to quit.");
                }
            }
        }

        // Input for hours worked
        while (true) {
            System.out.println("Enter hours worked (0-" + MAX_HOURS_WORKED + "): ");
            if (scan.hasNextInt()) {
                int tempInput = scan.nextInt();
                if (tempInput >= 1 && tempInput <= MAX_HOURS_WORKED) {
                    this.hoursWorked = tempInput;
                    scan.nextLine(); // consume the leftover newline
                    break;
                } else {
                    if (tempInput > MAX_HOURS_WORKED) {
                        this.hoursWorked = MAX_HOURS_WORKED;
                        this.overtimeHours = tempInput - MAX_HOURS_WORKED;
                        scan.nextLine(); // consume the leftover newline
                        break;
                    } else {
                        System.out.println("Invalid entry. Please enter hours between 0 and " + MAX_HOURS_WORKED);
                    }
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter hours between 0 and " + MAX_HOURS_WORKED + " or 'q' to quit.");
                }
            }
        }
    }

    @Override
    public void getEarnings() {
        double regularEarnings = this.hourlyPay * this.hoursWorked;
        double overtimeEarnings = this.hourlyPay * OVERTIME_RATE * this.overtimeHours;
        double totalEarnings = regularEarnings + overtimeEarnings + this.getBonus();
        super.setPaycheck(totalEarnings);
    }
        

    public String toString() {
        return String.format(super.toString() +
                "\n-------------------\n" +
                "Hourly rate: $%,.2f\n" +
                "Standard Hours worked: %,.2f\n" +
                "Overtime Hours worked: %,.2f\n" +
                "Standard Earnings: $%,.2f\n" +
                "Overtime Earnings: $%,.2f\n" +
                "Bonus: $%,.2f\n" +
                "Paycheck Total: $%,.2f",
                this.hourlyPay,
                this.hoursWorked,
                this.overtimeHours,
                this.hoursWorked * this.hourlyPay,
                this.overtimeHours * this.hourlyPay * 1.5,
                this.getBonus(),
                this.getPaycheck());
    }
}
