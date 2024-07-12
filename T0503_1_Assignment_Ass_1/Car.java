/**
 * 
 */
package T0503_1_Assignment_Ass_1;


/**Car.java
 * Efemona Avre
 * 
 * This class models a car. 
 * this model will serve as a superclass for used and new cars, and may be in a aggregation relationship with other classes
 * 
 */
public class Car {
	double price;
	
	public Car(double cost) {
		this.price = cost * 2;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void display() {
		System.out.printf("Price: $%,.2f%n", price);
	}
	

}
