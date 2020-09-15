package inheritance;

public class Woman extends Person {
	String food;
	
	public Woman(String name, int age, String food) {
		super(age, name);
		this.food = food;
	}
}
