package T0502_1_Assignment3;

import java.util.Arrays;
import java.util.Random;

/**
 * Manages and displays product information and sales data.
 */
public class ProductManager {
    public static void main(String[] args) {
        // Create an array of Product objects
        Product[] allProducts = {
                new Product("iphone-X", 112310, new double[]{1150.0, 1200.932, 1450.99}),
                new Product("iphone-XR", 112311, new double[]{1250.0, 1300.932, 1550.99}),
                new Product("iphone-11", 112312, new double[]{1700.0, 1400.932, 1650.99}),
                new Product("iphone-12", 112313, new double[]{1350.0, 1500.932, 1750.99}),
                new Product("iphone-13", 112314, new double[]{1400.0, 1600.932, 1850.99}),
                new Product("iphone-13 Pro", 112315, new double[]{1450.0, 1700.932, 1950.99}),
                new Product("iphone-13 Pro Max", 112316, new double[]{1500.0, 1800.932, 2050.99}),
                new Product("iphone-14", 112317, new double[]{1560.0, 300.932, 2150.99}),
                new Product("iphone-14 pro", 112318, new double[]{1800.0, 2000.932, 2250.99}),
        };

        // Display the information of all products
        for (Product product : allProducts) {
            product.displayProductInfo();
        }

        // Generate random weekly sales data
        Random random = new Random();
        int[] weeklySales = new int[48];
        for (int i = 0; i < weeklySales.length; i++) {
            weeklySales[i] = random.nextInt(100);
        }

        // Display the weekly sales using Arrays.toString() method
        System.out.println("Weekly Sales:\n" + Arrays.toString(weeklySales));

        // Display the weekly sales using a for-each loop
        StringBuilder weeklySalesString = new StringBuilder("Weekly Sales:\n[");
        for (int sales : weeklySales) {
            weeklySalesString.append(sales).append(", ");
        }
        if (weeklySalesString.length() > 2) {
            weeklySalesString.setLength(weeklySalesString.length() - 2);
        }
        weeklySalesString.append("]\n");
        System.out.println(weeklySalesString);

        // Create and display monthly sales data
        int[][] monthlySales = new int[12][4];
        int weekIndex = 0;
        System.out.print("Sales numbers:\nMonth #: [Week1, Week2, Week3, Week4]\n");
        for (int i = 0; i < 12; i++) {
            System.arraycopy(weeklySales, weekIndex, monthlySales[i], 0, 4);
            weekIndex += 4;
            System.out.printf("Month %d: %s\n", i + 1, Arrays.toString(monthlySales[i]));
        }

        // Display average sales for month 2 and sorted prices for product 5
        System.out.printf("Average Sale for Month 2: %.2f\n", Product.findAverageSales(monthlySales[1]));
        System.out.println("Product 3 Prices: " + Arrays.toString(allProducts[4].getProductPrices()));

        // Sort and display prices using manual sort
        double[] sortedPricesManual = Product.manualSort(allProducts[4].getProductPrices());
        System.out.printf("Sorted Prices (Manual): \n%s\n", Arrays.toString(sortedPricesManual));

        // Sort and display prices using Arrays.sort
        double[] sortedPricesArrays = Product.arraysSort(allProducts[4].getProductPrices());
        System.out.printf("Sorted Prices (Arrays.sort): \n%s\n", Arrays.toString(sortedPricesArrays));

        // Create and display a 5x5 two-dimensional array
        int[][] matrix = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
        System.out.println("Two-dimensional Array:");
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.printf("%3d ", number);
            }
            System.out.println();
        }
    }
}
