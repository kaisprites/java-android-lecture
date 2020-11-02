package cook;

public class ChineseCook implements ICook {

	@Override
	public void makeRice() {
		System.out.println("make Chinese rice");
	}

	@Override
	public void makeSoup() {
		System.out.println("make Chinese soup");
	}

	@Override
	public void makeSalad() {
		System.out.println("make Chinese salad");
	}

	@Override
	public void makeSauce() {
		System.out.println("make Chinese sauce");
	}

}
