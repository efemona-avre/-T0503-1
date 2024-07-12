package t0501_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressCanada {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter Canada address in the following format:\n");
        System.out.println("[House Number] [Street Name], [City], [Province], [Postal Code]\n");
        System.out.println("address: ");
        String userTextInput = scan.nextLine(); // Use nextLine() to read the entire input
        Address newAddress = new Address();
        if (Address.checkAddress(userTextInput)) {
            newAddress.registerAddress(userTextInput);
            newAddress.display();
        } else {
            System.out.println("Invalid address format.");
        }
        scan.close();
    }

    public static class Address {
        private static Map<String, String> addressElements = new HashMap<>();

        public static void registerAddress(String userTextInput) {
            String[] parts = userTextInput.split(",\\s*"); // Split by comma and optional spaces

            if (parts.length == 4) {
                String[] streetParts = parts[0].split("\\s+", 2); // Split by first space for house number and street name
                if (streetParts.length == 2) {
                    addressElements.put("House Number", streetParts[0]);
                    addressElements.put("Street Name", streetParts[1]);
                } else {
                    System.out.println("Invalid address format in house number and street name.");
                    return;
                }

                addressElements.put("City", parts[1].trim()); // City
                addressElements.put("Province", parts[2].trim()); // Province
                addressElements.put("Postal Code", parts[3].trim()); // Postal Code
            } else {
                System.out.println("Invalid address format in number of parts.");
            }
        }

        public void display() {
            System.out.println("Street Name: " + addressElements.get("Street Name"));
            System.out.println("House Number: " + addressElements.get("House Number"));
            System.out.println("City: " + addressElements.get("City"));
            System.out.println("Province: " + addressElements.get("Province"));
            System.out.println("Postal Code: " + addressElements.get("Postal Code"));
        }

        public static boolean checkAddress(String userTextInput) {
            // Check for basic validity of the address format
            String[] parts = userTextInput.split(",\\s*");
            if (parts.length == 4) {
                String[] streetParts = parts[0].split("\\s+", 2);
                return streetParts.length == 2;
            }
            return false;
        }
    }
}
