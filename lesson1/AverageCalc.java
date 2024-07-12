package lesson1;

import java.util.Scanner;

public class AverageCalc {

    public static void main(String[] args) {
        double average;
        int sum_of_values = 0, number_of_values = 0;
        Scanner scan = new Scanner(System.in);
        String userInput;

        while (true) {
            System.out.println("Enter a number or `n` to calculate the average: ");
            if (scan.hasNextInt()) {
                sum_of_values += scan.nextInt();
                ++number_of_values;
                average = (double) sum_of_values / number_of_values;
                
                System.out.println("Sum of values: " + sum_of_values);
                System.out.println("Number of values: " + number_of_values);
                System.out.println("Current average: " + average);
            } else if (scan.hasNext()) {
                userInput = scan.next();
                if (userInput.equals("n")) {
                    break;
                } else {
                	System.out.println("Invalid entry");
                }
            }
        }

        

        if (number_of_values != 0) {
            average = (double) sum_of_values / number_of_values;
            System.out.println("Average: " + average);
        } else {
            System.out.println("No values entered, cannot calculate average.");
        }

        scan.close();
    }

}
