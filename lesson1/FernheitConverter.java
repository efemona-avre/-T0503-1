package lesson1;

import java.util.Scanner;

public class FernheitConverter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the Fahrenheit value or 'q' to quit: ");
            if (scan.hasNextDouble()) {
                double fahrenheit = scan.nextDouble();
                double celsiusValue = convert(fahrenheit);
                System.out.println(fahrenheit + " deg Fahrenheit equals " + celsiusValue + " deg Celsius.");
            } else {
                String input = scan.next();
                if (input.equals("q")) {
                	System.out.println("Thanks and goodbye!");
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number or 'q' to quit.");
                }
            }
        }

        scan.close();
    }

    private static double convert(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

}
