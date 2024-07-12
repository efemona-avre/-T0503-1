package T0503_1_Assignment_Ass_1;
/**
 * UsedCar.java
 * Efemona Avre
 * Assignment 2: Aggregation and Compensation - Car Program (Graded)
 * 
 * This class models a used car, extending the Car class.
 * It adds an attribute for the mileage of the car.
 */
public class UsedCar extends Car {
    public int mileage;

    /**
     * Constructor to initialize a used car with a given cost and mileage.
     * 
     * @param cost The initial cost of the car.
     * @param mileage The mileage of the car.
     */
    public UsedCar(double cost, int mileage) {
        // Call the superclass constructor
        super(cost);
        this.mileage = mileage;
    }

    /**
     * Checks if this used car is equal to another used car based on mileage and price.
     * 
     * @param car The other used car to compare with.
     * @return True if the cars are equal, false otherwise.
     */
    public boolean equals(UsedCar car) {
        return car.mileage == this.mileage && car.getPrice() == this.getPrice();
    }

    /**
     * Displays the price and mileage of the car.
     */
    public void display() {
        super.display();
        System.out.printf("Mileage: %d%n", mileage);
    }
}