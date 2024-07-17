package T0503_1_Assignment_Ass_3;

import java.util.Scanner;

public class Hourly extends Employee {
	private double hourlyPay;
	private double hoursWorked;
	private double overtimeHours;
	
	void load(Scanner scan) {
		super.load(scan);
     
        // Input for hourly pay
        while (true) {
        	
            System.out.println("Enter Hourly pay Number (1-9999.99): ");
            if (scan.hasNextDouble()) {
                double tempInput = scan.nextDouble();
                if (tempInput >= 1.0 && tempInput <= 9999.99) {
                    this.hourlyPay = tempInput;
                    scan.nextLine(); // consume the leftover newline
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1.0 and 9999.99");
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1.0 and 9999.99 or 'q' to quit.");
                }
            }
        }

        // Input for Hours worked. Max hours per week is 40. if over 40, 
        while (true) {
            System.out.println("Enter hours worked (0-999): ");
            if (scan.hasNextInt()) {
                int tempInput = scan.nextInt();
                if (tempInput >= 1 && tempInput <= 40) {
                    this.hoursWorked = tempInput;
                    scan.nextLine(); // consume the leftover newline
                    
                } else {
                	//hour worked exceeds maximum of 40, the balance is overtime hours.
                	if (tempInput >40) {
                		this.hoursWorked = 40;
                		this.overtimeHours = tempInput - 40;	
                	}
                	break;
                }
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                    System.out.println("Thanks and goodbye!");
                    return;
                } else {
                    System.out.println("Invalid entry. Please enter a hours between 0 and 40. or 'q' to quit.");
                }
            }
        }

	}

	public Hourly getEarning() {
		double earnings = (this.hourlyPay * this.hoursWorked) + (this.hourlyPay *1.5  * this.overtimeHours) + this.getBonus();
		super.setPaycheck(earnings)  ;
		return this;
	}
	
	public String toString() {
		
		String formatedString = String.format(super.toString() + "-------------------\n"
				+ "Hourly rate : $%,.2f\n"
				+ "Standard Hours worked : %d\n"
				+ "Overtime Hours worked: %d\n"
				+ "Standard Earnings : $%,.2f\n"
				+ "Overtime earning : $%,.2f\n"
				+ "Bonus : $%,.2f\n"
				+ "Paycheck Total : $%,.2f",
				this.hourlyPay,
				this.hoursWorked, 
				this.overtimeHours, 
				this.hoursWorked * this.hourlyPay, 
				this.overtimeHours * this.hourlyPay *1.5 , 
				this.getBonus(),
				this.getPaycheck());
		
		return formatedString;	
		
	}
}
