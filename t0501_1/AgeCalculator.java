package t0501_1;
/*
 * Efemona Avre
 * Assignment 1: Age Calculator (Graded)
 *
 * */

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class AgeCalculator {
	/*
	 * This class calculates the age based on user inputs
	 * the result is a string that tells the years, months and days old. 
	 * */
	
    public static void main(String[] args) {
    	/**
         * Main method that collects user input for date of birth and calculates the age.
         */
        int counter = 0;
        Map<String, Integer> dateMap = new HashMap<>();//Hashmap to store dateData
        dateMap.put("day", 0);
        dateMap.put("month", 0);
        dateMap.put("year", 0);
        Scanner scan = new Scanner(System.in); //user input object
        System.out.println("Welcome to age calculator.");
        System.out.println("Enter your date of birth as dd/mm/yyyy.");

        while (counter < 3) { 
        	
            switch (counter) {
                case 0://check for days input
                    System.out.print("Enter day: ");
                    if (scan.hasNextInt()) {
                        dateMap.put("day", scan.nextInt());
                        ++counter;
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scan.next(); // discard current input, ready for next reading
                    }
                    break;

                case 1: //checks for month input
                    System.out.print("Enter month: ");
                    if (scan.hasNextInt()) {
                        dateMap.put("month", scan.nextInt());
                        ++counter;
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scan.next();
                    }
                    break;

                case 2: //checks for years input
                    System.out.print("Enter year: ");
                    if (scan.hasNextInt()) {
                        dateMap.put("year", scan.nextInt());
                        ++counter;
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scan.next(); 
                    }
                    break;
            }
        }

        computeAge(dateMap);
        
    }

    public static void computeAge(Map<String, Integer> dateMap) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the age
        int yearsGone = currentDate.getYear() - dateMap.get("year");
        int monthsGone = currentDate.getMonthValue() - dateMap.get("month");
        int daysGone = currentDate.getDayOfMonth() - dateMap.get("day");

        // Adjust for negative values
        if (daysGone < 0) {
            monthsGone--;
            daysGone += currentDate.lengthOfMonth(); // Get the length of the current month
        }
        if (monthsGone < 0) {
            yearsGone--;
            monthsGone += 12; // There are 12 months in a year
        }

        // Display the age
        String yearString = yearsGone == 1 ? "year" : "years";
        String monthString = monthsGone == 1 ? "month" : "months";
        String dayString = daysGone == 1 ? "day" : "days";
        String message = String.format("You are %d %s, %d %s, %d %s old!", yearsGone, yearString, monthsGone, monthString, daysGone, dayString);
        System.out.println(message);
    }

}
