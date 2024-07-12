/**
 * 
 */
package lesson1;

import java.util.Scanner;

/**
 * 
 */
public class MyClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y, answer;
		Scanner scan = new Scanner (System.in);
		System.out.println("input x:");
		x = scan.nextInt();
		System.out.println("input y:");
		y = scan.nextInt();
		answer = x * y;
		System.out.println("The product of x and y is " + answer );
		
	}

}
