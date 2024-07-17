package T0503_1_Assignment_Ass_3;
import java.util.Scanner;

public class PayrollDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Hourly e1 = new Hourly();
		e1.load(scan);
		scan.close();
		e1.getEarning();
		System.out.println(e1);
	}

}
