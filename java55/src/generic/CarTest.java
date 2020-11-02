package generic;

public class CarTest {
	public static void main(String[] args) {
		Car<String> cls = new Car<String>("bigsize");
		System.out.println(cls.getSize());
		Car<Integer> cli = new Car<Integer>(5);
		System.out.println(cli.getSize());
	}
}
