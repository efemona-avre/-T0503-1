package T0503_1_Assignment_Ass_1;

public class UsedCar extends Car{
	public int mileage;
	

	public UsedCar( double cost, int mileage) {
		// TODO Auto-generated constructor 
		super(cost);
		this.mileage = mileage;
		
	}
	
	public boolean equals(UsedCar car) {
		return car.mileage == this.mileage && car.getPrice()== this.getPrice();
	}
	
	public void display() {
		super.display();
		System.out.printf("Mileage : %d\n", mileage );
	}


}
