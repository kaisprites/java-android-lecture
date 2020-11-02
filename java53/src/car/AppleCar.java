package car;

public class AppleCar implements Car {

	@Override
	public void startCar() {
		System.out.println("사과차 시동걸림");
	}

	@Override
	public void stopCar() {
		System.out.println("사과차 시동끊어짐");
	}

}
