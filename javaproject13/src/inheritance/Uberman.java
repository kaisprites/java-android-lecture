package inheritance;

public class Uberman extends Man {
	//멤버변수3개, 메서드2개
	boolean fly;
	public void space() {
		System.out.println("우주를 날다");
	}
	public Uberman(int age, String name, int power, boolean fly) {
		super(age, name, power);
		this.fly = fly;
	}
	@Override
	public String toString() {
		return "Uberman [fly=" + fly + ", power=" + power + ", age=" + age + ", name=" + name + "]";
	}
}
