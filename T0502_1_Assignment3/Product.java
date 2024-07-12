package T0502_1_Assignment3;

import java.util.Arrays;

/**
 * Represents a Product with a name, ID, and a list of prices.
 */
public class Product {
    private final String productName;
    private final int productID;
    private double[] prices;

    /**
     * Constructor to initialize a Product.
     *
     * @param productName Name of the product.
     * @param productID   ID of the product.
     * @param prices      List of prices of the product.
     */
    public Product(String productName, int productID, double[] prices) {
        this.productName = productName;
        this.productID = productID;
        this.prices = prices.clone();
    }

    /**
     * Displays the product information.
     */
    public void displayProductInfo() {
        System.out.printf("Product Name: %s\nProduct ID: %d\nPrices $: %s\n****\n\n",
                this.productName, this.productID, this.viewAllPrices());
    }

    /**
     * Returns a copy of the product prices.
     *
     * @return A copy of the prices array.
     */
    public double[] getProductPrices() {
        return prices.clone();
    }

    /**
     * Returns a string representation of all prices.
     *
     * @return A string representation of the prices array.
     */
    public String viewAllPrices() {
        return Arrays.toString(this.getProductPrices());
    }

    /**
     * Calculates the average sales from the given weekly sales data.
     *
     * @param weeklySales Array of weekly sales.
     * @return The average sales.
     */
    public static double findAverageSales(int[] weeklySales) {
        int sum = 0;
        for (int sale : weeklySales) {
            sum += sale;
        }
        return weeklySales.length > 0 ? (double) sum / weeklySales.length : 0.0;
    }

    /**
     * Sorts an array of double values manually (selection sort).
     *
     * @param valuesList Array of double values to be sorted.
     * @return The sorted array.
     */
    public static double[] manualSort(double[] valuesList) {
        double[] sortedArray = valuesList.clone();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < sortedArray[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // Swap elements
                double temp = sortedArray[i];
                sortedArray[i] = sortedArray[minIndex];
                sortedArray[minIndex] = temp;
            }
        }
        return sortedArray;
    }

    /**
     * Sorts an array of double values using Arrays.sort.
     *
     * @param valuesList Array of double values to be sorted.
     * @return The sorted array.
     */
    public static double[] arraysSort(double[] valuesList) {
        double[] sortedArray = valuesList.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
