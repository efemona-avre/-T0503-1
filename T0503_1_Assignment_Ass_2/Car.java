/**
 * This package contains the classes for the car assignment.
 */
package T0503_1_Assignment_Ass_2;

/**
 * Car.java
 * Efemona Avre
 * Assignment 2: Aggregation and Compensation - Car Program (Graded)
 * 
 * This class models a car. 
 * This model will serve as a superclass for used and new cars, 
 * and may be in an aggregation relationship with other classes.
 */
public class Car {
    double price;

    /**
     * Constructor to initialize the car with a given cost.
     * The price is calculated as twice the given cost.
     * 
     * @param cost The initial cost of the car.
     */
    public Car(double cost) {
        this.price = cost * 2;
    }

    /**
     * Returns the price of the car.
     * 
     * @return The price of the car.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Displays the price of the car formatted as currency.
     */
    public void display() {
        System.out.printf("Price: $%,.2f%n", price);
    }
}
