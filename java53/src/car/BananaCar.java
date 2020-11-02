package car;

public class BananaCar implements Car {

	@Override
	public void startCar() {
		System.out.println("바나나차 시동걸림");
	}

	@Override
	public void stopCar() {
		System.out.println("바나나차 시동끊어짐");
	}

}
