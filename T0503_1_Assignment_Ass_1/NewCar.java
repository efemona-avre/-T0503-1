package T0503_1_Assignment_Ass_1;

/**
 * NewCar.java
 * Efemona Avre
 * Assignment 2: Aggregation and Compensation - Car Program (Graded)
 * 
 * This class models a new car, extending the Car class.
 * It adds an attribute for the color of the car.
 */

public class NewCar extends Car {
    public String color;

    /**
     * Constructor to initialize a new car with a given cost and color.
     * 
     * @param cost The initial cost of the car.
     * @param color The color of the car.
     */
    public NewCar(double cost, String color) {
        // Call the superclass constructor
        super(cost);
        this.color = color;
    }

    /**
     * Checks if this new car is equal to another new car based on color and price.
     * 
     * @param car The other new car to compare with.
     * @return True if the cars are equal, false otherwise.
     */
    public boolean equals(NewCar car) {
        return car.color.equals(this.color) && car.getPrice() == this.getPrice();
    }
    
    /**
     * Displays the price and color of the car.
     */
    public void display() {
        super.display();
        System.out.printf("Color: %s%n", color);
    }
}