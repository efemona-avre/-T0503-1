package t0501_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to Math Calculator");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the side length: ");
        int sideLength = scanner.nextInt();
        scanner.close();

        Map<String, Double> results = calculate(sideLength);
        
        System.out.printf("AREA: %.2f\n", results.get("area"));
        System.out.printf("PERIMETER: %.2f\n", results.get("perimeter"));
        System.out.printf("VOLUME: %.2f\n", results.get("volume"));
    }

    public static Map<String, Double> calculate(int sideLength) {
        double area = Math.pow(sideLength, 2); //calculates area
        double perimeter = 4 * sideLength; //calculates perimeter
        double volume = Math.pow(sideLength, 3); //calculates volume

        Map<String, Double> results = new HashMap<>();
        results.put("area", area);
        results.put("perimeter", perimeter);
        results.put("volume", volume);

        return results;
    }
}
