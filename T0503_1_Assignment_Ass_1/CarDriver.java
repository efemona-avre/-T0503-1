package T0503_1_Assignment_Ass_1;

/**
 * CarDriver.java
 * Efemona Avre
 * Assignment 2: Aggregation and Compensation - Car Program (Graded)
 * 
 * This class contains the main method to test the Car, NewCar, and UsedCar classes.
 */
public class CarDriver {

    public static void main(String[] args) {
        // Create two new car objects with the same cost and color
        NewCar new1 = new NewCar(8000.33, "silver");
        NewCar new2 = new NewCar(8000.33, "silver");

        // Check if the two new cars are equal and display if they are
        if (new1.equals(new2)) {
            new1.display();
        }

        // Create two used car objects with the same cost and mileage
        UsedCar used1 = new UsedCar(2500.0, 100000);
        UsedCar used2 = new UsedCar(2500.0, 100000);

        // Check if the two used cars are equal and display if they are
        if (used1.equals(used2)) {
            used1.display();
        }
    } // end main
}