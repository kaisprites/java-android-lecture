package inheritance;

public class Man extends Person {
	//멤버변수2개, 메서드1개
	int power;
	public Man(int age, String name, int power) {
		super(age, name);
		this.power = power;
	}
	public void run () {
		System.out.println("달리다");
	}
}
