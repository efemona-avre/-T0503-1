package T0503_1_Assignment_Ass_3;

import java.util.ArrayList;
import java.util.Scanner;

public class PayrollDemo {

    // Named constants
    private static final int MIN_EMPLOYEE_COUNT = 1;
    private static final int MAX_EMPLOYEE_COUNT = 100;
    private static final int MIN_OPTION = 1;
    private static final int MAX_OPTION = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();

        int employeeCount = getEmployeeCount(scanner);

        for (int i = 1; i <= employeeCount; i++) {
            int profileSelection = getProfileSelection(scanner, i);
            Employee employee = createEmployee(profileSelection, scanner);
            if (employee != null) {
                employee.getEarnings();
                employeeList.add(employee);
            }
        }

        // display the list of employees and their details
        displayEmployees(employeeList);

        scanner.close();
    }

    private static int getEmployeeCount(Scanner scanner) {
        int employeeCount = 0;
        while (true) {
            System.out.print("Enter number of employees (" + MIN_EMPLOYEE_COUNT + "-" + MAX_EMPLOYEE_COUNT + "): ");
            if (scanner.hasNextInt()) {
                employeeCount = scanner.nextInt();
                scanner.nextLine(); // consume the leftover newline
                if (employeeCount >= MIN_EMPLOYEE_COUNT && employeeCount <= MAX_EMPLOYEE_COUNT) {
                    break;
                } else {
                    System.out.println("Invalid entry. Please enter a number between " + MIN_EMPLOYEE_COUNT + " and " + MAX_EMPLOYEE_COUNT + ".");
                }
            } else {
                System.out.println("Invalid entry. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
        }
        return employeeCount;
    }

    private static int getProfileSelection(Scanner scanner, int employeeNumber) {
        int profileSelection = 0;
        while (true) {
            System.out.printf("PROFILE FOR EMPLOYEE #%d:\n", employeeNumber);
            System.out.println(">>Enter 1 for Hourly");
            System.out.println(">>Enter 2 for Salaried");
            System.out.println(">>Enter 3 for Salaried plus Commissioned");
            System.out.print("Employee Profile (Enter Number): ");
            if (scanner.hasNextInt()) {
                profileSelection = scanner.nextInt();
                scanner.nextLine(); // consume the leftover newline
                if (profileSelection >= MIN_OPTION && profileSelection <= MAX_OPTION) {
                    break;
                } else {
                    System.out.println("Invalid selection. Enter a value between " + MIN_OPTION + " and " + MAX_OPTION + ".");
                }
            } else {
                System.out.println("Invalid entry. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
        }
        return profileSelection;
    }

    private static Employee createEmployee(int profileSelection, Scanner scanner) {
        Employee employee = null;
        switch (profileSelection) {
            case 1:
                employee = new Hourly();
                break;
            case 2:
                employee = new Salaried();
                break;
            case 3:
                employee = new SalariedPlus();
                break;
            default:
                System.out.println("Invalid selection. Employee not created.");
                return null;
        }
        if (employee != null) {
            employee.load(scanner);
        }
        return employee;
    }

    private static void displayEmployees(ArrayList<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println(employee);
            System.out.println();
        }
    }
}
