package inheritance;

public class Truck extends Car {
	int payload;
	
	public Truck(int speed, String color, int payload) {
		super(speed, color);
		this.payload = payload; 
	}
}
