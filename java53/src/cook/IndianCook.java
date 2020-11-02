package cook;

public class IndianCook implements ICook {

	@Override
	public void makeRice() {
		System.out.println("make Indian rice");
	}

	@Override
	public void makeSoup() {
		System.out.println("make Indian soup");
	}

	@Override
	public void makeSalad() {
		System.out.println("make Indian salad");
	}

	@Override
	public void makeSauce() {
		System.out.println("make Indian sauce");
	}

}
