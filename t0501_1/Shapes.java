package t0501_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shapes {

    public static void main(String[] args) {
        // Printing menu prompts
        System.out.println("********** Drawing shapes ***********");
     // Take shape input from user
        Scanner scan = new Scanner(System.in);
        while (true) {
        	System.out.println("Choose one of the following #: ");
        	System.out.println("1. Exit");
            System.out.println("2. Draw");
            System.out.print("Selection: ");
            int menuSelection = scan.nextInt(); // check user input is integer and between 1 and 4
            scan.nextLine(); // Consume newline character
        		if (menuSelection == 1) {
        			System.out.println("Thanks for playing!!");
        			break;}
        		else {
        			playDraw();
        		}
        }

     }


    public static void playDraw() {
    	System.out.println("Menu: Pick a type of shape to draw.");
        Shape newShape = new Shape();
        newShape.showMenu();

        // Take shape input from user
        Scanner scan = new Scanner(System.in);
        System.out.print("Shape #: ");
        int shapeSelection = scan.nextInt(); // check user input is integer and between 1 and 4
        scan.nextLine(); // Consume newline character
        if (shapeSelection < 1 || shapeSelection > 4) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
           // Exit the program if input is invalid
        } else {
        	// Process the selected shape
            Map<String, Object> selectedShape = Shape.selectedShape(shapeSelection);
            System.out.println("You selected: " + selectedShape.get("type"));

            // Prompt user for width and length
            Map<String, Integer> dimensions = newShape.getDimensions(scan, selectedShape);

            // Update the selectedShape map with the dimensions
            selectedShape.putAll(dimensions);

            // Draw the selected shape
            newShape.draw(selectedShape);

        }
    }


    public static class Shape {
        private static Map<String, Map<String, Object>> outerMap = new HashMap<>();

        static {
            // Initialize the outer map
            outerMap.put("H-Line", new HashMap<String, Object>() {{
                put("type", "Horizontal Line");
                put("ext_key", 1);
                put("menu_prompt", "# enter 1 - a Horizontal line");
                put("setters", Arrays.asList("width"));
            }});

            outerMap.put("V-Line", new HashMap<String, Object>() {{
                put("type", "Vertical Line");
                put("ext_key", 2);
                put("menu_prompt", "# enter 2 - a Vertical line");
                put("setters", Arrays.asList("length"));
            }});

            outerMap.put("Square", new HashMap<String, Object>() {{
                put("type", "Square");
                put("ext_key", 3);
                put("menu_prompt", "# enter 3 - a Square or Rectangle");
                put("setters", Arrays.asList("width", "length"));
            }});

            outerMap.put("Triangle", new HashMap<String, Object>() {{
                put("type", "Triangle");
                put("ext_key", 4);
                put("menu_prompt", "# enter 4 - a Triangle");
                put("setters", Arrays.asList("width", "length"));
            }});
        }

        public static Map<String, Object> selectedShape(int shapeSelection) {
            String shapeKey = getShapeKey(shapeSelection);
            return outerMap.get(shapeKey); // returns a HashMap of String : object matching the selected shape
        }

        private static String getShapeKey(int shapeSelection) {
            switch (shapeSelection) {
                case 1:
                    return "H-Line";
                case 2:
                    return "V-Line";
                case 3:
                    return "Square";
                case 4:
                    return "Triangle";
                default:
                    return "";
            }
        }

        public static void showMenu() {
            for (Map<String, Object> innerMap : outerMap.values()) {
                System.out.println(innerMap.get("menu_prompt"));
            }
        }

        public Map<String, Integer> getDimensions(Scanner scan, Map<String, Object> selectedShape) {
            Map<String, Integer> dimensions = new HashMap<>();
            for (String setter : (Iterable<String>) selectedShape.get("setters")) {
                System.out.print("enter " + setter + ": ");
                int value = scan.nextInt();
                dimensions.put(setter, value);
            }
            scan.nextLine(); // Consume newline character
            return dimensions;
        }

        public void draw(Map<String, Object> selectedShape) {
            // Implement the draw logic here based on the shape type and dimensions
            // This method will be implemented in future updates
        	if (selectedShape.get("type").equals("Square") &&
        			(int) selectedShape.get("width") != (int) selectedShape.get("length")){
        		selectedShape.put("type","Rectangle");
        	}

        	//Print the shape type being drawn
            System.out.println(String.format("Drawing the %s shape...", selectedShape.get("type")));

            // Retrieve width and length from the selectedShape map
            int width = selectedShape.containsKey("width") ? (int) selectedShape.get("width") : 0;
            int length = selectedShape.containsKey("length") ? (int) selectedShape.get("length") : 0;

            // Draw the shape based on its type
            switch ((int) selectedShape.get("ext_key")) {
                case 1: // Horizontal line
                    for (int i = 0; i < width; i++) {
                        System.out.print("#");
                    }
                    break;
                case 2: // Vertical line
                    for (int i = 0; i < length; i++) {
                        System.out.println("#");
                    }
                    break;
                case 3: // Square or Rectangle
                    for (int i = 0; i < length; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print("#");
                        }
                        System.out.println();
                    }
                    break;
                case 4: // Triangle
                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < width - i - 1; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < 2 * i + 1; j++) {
                            if (j % 2 == 0) {
                                System.out.print("*");
                            } else {
                                System.out.print("#");
                            }
                        }

                    }
                    break;
                default:
                    System.out.println("Shape not supported yet.");
                    break;
            }
            System.out.println();

        }
    }
}
