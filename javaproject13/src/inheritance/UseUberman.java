package inheritance;

public class UseUberman {

	public static void main(String[] args) {
		Uberman s = new Uberman();
		s.age = 1000;
		s.name = "Clark";
		s.power = 10000;
		s.fly = true;
		
		System.out.println(s);
		
		s.eat();
		s.run();
		s.space();
	}

}
