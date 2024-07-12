/**
 * 
 */
package T0502_1;
/*************************************
 * Person.java
 * Efemona Avre
 * 
 * This class models a Person object
 */



public class Person {
	// instance variables
	private String name; // person name
	private int age; // person Age 
	private String email; //person email address
	
	//***********************************************************
	
	public Person(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}
	
	public void displayInfo() {
		String address = "123 Main St, Anytown, USA"; // Local variable
		System.out.printf("Name: %s \n"
						 + "Age: %d \n"
						 + "email: %s \n", this.name, this.age, this.email);
	}
	
	public int calculateBirthYear(int currentYear) {
		//calculates birth year by subtracting age instance variable from the given current year
		return currentYear - this.age;
	}
	
	public boolean isAdult() {
		//Checks if the person is an adult by comparing the age instance variable with 18. 
	
		return this.age >= 18;
	}

}
