package T0502_1_Assignment2;
/*Product Class Driver
 * Written by: Efemona Avre
 * Assignment 2 
 * 
 * 
 * 
 * This class demonstrates the attributes and methods of the Product class
 * */

public class ProductDemo {
	
	
	public static void main(String[] args) {
		
		Product p1 = new Product("Laptop", 999.99, 12345);//creates an instance with parameters of a product object
		Product p2 = new Product("Laptop", 999.99, 12345);//creates an instance with parameters of a product object
		Product p3 = new Product("Tablet", 299.99, 54321);
		Product p4 = new Product("Phone", 399.99, 34453);
		
		System.out.println("Product 1 information:");
		p1.printProductInfo();
		
		System.out.println("Product 2 information:");
		p1.printProductInfo();
		
		System.out.println("Product 1 EQUALS product 2 :" + p1.equals(p2)); //Checks and prints the result instance method 'equals'
		
		System.out.println("\nProduct 3 information:");
		p3.printProductInfo(); // implementation of part 3
		System.out.print("Product 3 Information with Product Code: ");
		p3.printProductInfo(true); // implementation of part 3
		
		System.out.printf("Total Product count: %d\n",Product.getProductCount());
		System.out.printf("Tax Amount for Product 4: $%.3f\n", p4.getTaxRate());
	}

}
