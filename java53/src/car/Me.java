package car;

public class Me {
	public static void main(String[] arg) {
		AppleCar apc = new AppleCar();
		BananaCar bac = new BananaCar();
		apc.startCar();
		bac.startCar();
		apc.stopCar();
		bac.stopCar();
	}
}
