package inheritance;

public class Wonderwoman extends Woman {
	boolean swim;
	
	public Wonderwoman(String name, int age, String food, boolean swim) {
		super(name, age, food);
		this.swim = swim;
	}

	@Override
	public String toString() {
		return "Wonderwoman [swim=" + swim + ", food=" + food + ", age=" + age + ", name=" + name + "]";
	}
	
	
}
