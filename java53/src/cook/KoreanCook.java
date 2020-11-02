package cook;

public class KoreanCook implements ICook {

	@Override
	public void makeRice() {
		System.out.println("make Korean rice");
	}

	@Override
	public void makeSoup() {
		System.out.println("make Korean soup");
	}

	@Override
	public void makeSalad() {
		System.out.println("make Korean salad");
	}

	@Override
	public void makeSauce() {
		System.out.println("make Korean sauce");
	}

}
