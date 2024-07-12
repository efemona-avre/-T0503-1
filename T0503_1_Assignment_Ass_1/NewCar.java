package T0503_1_Assignment_Ass_1;

public class NewCar extends Car{
	public String color;
	

	public NewCar(double cost, String color) {
		// TODO Auto-generated constructor 
		super(cost);
		this.color = color;
		
	}
	
	public boolean equals(NewCar car) {
		return car.color.equals(this.color) && car.getPrice()== this.getPrice();
	}
	
	public void display() {
		super.display();
		System.out.printf("Color : %s\n", color );
	}

}
