package T0502_1_Assignment2;
/* Product.java
 * Efemona Avre
 * 
 * This Class models a product to demonstrate core principles of Object Oriented programming 
 * 
 * 
 * */
public class Product {
	private String name;
	private double price;
	private int productCode;
	private static int productCount = 0;  // a private static variable
	private static final double TAX_RATE = 0.1; // a private static named constant, 
	
	//*************************************************************************
	
	public Product(String name, double price, int productCode) {
		// class constructor with parameters for instantiating the objects instance variables
		
		this.name = name;
		this.price = price;
		this.productCode = productCode;
		
		Product.addProduct(); // called with a new instance of the product class to update the product count
		
	}
	
	public static int getProductCount() {
		// a static method that returns the static variable productCount
		return Product.productCount;
	}
	
	public boolean equals(Product product) {
		//checks if the calling instance is equal to another instance parsed as an argument
		
		return this.name.equals(product.name) &&
				this.price == product.price &&
				this.productCode == product.productCode;	
	}
	
	public void printProductInfo() {
		//prints the product information in a structured format
		System.out.printf("Name : %s\n"
				+ "Price: $%.2f\n"
				+ "Product Code: %d\n\n", this.name, this.price, this.productCode);
	}
	
	public void printProductInfo(boolean printProductCode) {
		// prints the product information with the product code in a single line if printProdutCode is true
		if (printProductCode) {
			System.out.printf("%s,"
					+ "$%.2f,"
					+ "Product Code: %d\n\n", this.name, this.price, this.productCode);
			return;
		}
		
		System.out.printf("Name : %s\n"
				+ "Price: $%.2f\n"
				+ "Product Code: %d\n", this.name, this.price, this.productCode);
	}
	
	private static void addProduct() {
		// a static modifier method of the product class
		//auto increments the productCount static variable when a new instance of the product count is created
		Product.productCount ++;
	}
	
	public double getTaxRate() {
		//implementation of part 4. 
		// returns the product of the tax_rate named constant and the instance variable price
		return Product.TAX_RATE * this.price;
	}

}
