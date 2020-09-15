package inheritance;

public class Car {
	int speed;
	String color;
	
	public Car(int speed, String color) {
		this.speed = speed;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Car [speed=" + speed + ", color=" + color + "]";
	}
}
