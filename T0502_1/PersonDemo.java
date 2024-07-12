/**
 * 
 */
package T0502_1;
/*************************************
 * PersonDemo.java
 * Person Driver class
 * Efemona Avre
 * 
 * This class simulates interaction with the person class. 
 */


public class PersonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person person1 = new Person("John", 28, "john.person@example.com");
		Person person2 = new Person("Alice", 17, "alice.person@example.com");
		System.out.println("Person 1");
		person1.displayInfo();
		System.out.println("Person 2");
		person2.displayInfo();
		
		// Attempt to access the local variable 'address'
        // This line will cause a compilation error because 'address' is not visible here
        // System.out.println(person1.address); // Uncommenting this line will cause an error
		// This error results from the address variable being a local variable of the Person Class displayInfo method.
		// the address variable is only visible or accessible inside the displayInfo method.
		
		System.out.printf("Person 1's Birth Year: %d \n", person1.calculateBirthYear(2024));
		System.out.printf("Person 2's Birth Year: %d \n", person2.calculateBirthYear(2024));
		System.out.printf("Person 1 is an adult: %s\n", person1.isAdult());
		System.out.printf("Person 2 is an adult: %s\n", person2.isAdult());
		
		//the isAdult method evaluates the condition age >= 18 and returns the result of this boolean expression (true or false).
	}

}
