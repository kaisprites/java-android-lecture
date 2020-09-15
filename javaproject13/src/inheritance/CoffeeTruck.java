package inheritance;

public class CoffeeTruck extends Truck {
	String coffeeType;
	
	public CoffeeTruck(int speed, String color, int payload, String coffeeType) {
		super(speed, color, payload);
		this.coffeeType =coffeeType;
	}

	@Override
	public String toString() {
		return "CoffeeTruck [coffeeType=" + coffeeType + ", payload=" + payload + ", speed=" + speed + ", color="
				+ color + "]";
	}
}
