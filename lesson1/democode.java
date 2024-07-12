package lesson1;

import java.util.Scanner;

public class democode {
    public static void main(String[] args) {
        String result;
        Scanner scan = new Scanner(System.in);
        int studentScore;
        System.out.print("enter student score: ");
        studentScore = scan.nextInt();
        if (studentScore >= 90) {
            result = "A+";
        } else if (studentScore >= 80) {
            result = "A";
        } else {
            result = "Below A";
        }
        System.out.println("Student grade: " + result);
    }
}
