package T0503_1_Assignment_Ass_1;

public class CarDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		  NewCar new1 = new NewCar(8000.33, "silver");
		  NewCar new2 = new NewCar(8000.33, "silver");
		  if (new1.equals(new2))
		  {
			new1.display();
		  }
		  UsedCar used1 = new UsedCar(2500.0, 100000);
		  UsedCar used2 = new UsedCar(2500.0, 100000);
		  if (used1.equals(used2))
		  {
			used1.display();
		  }
		} // end main


}
