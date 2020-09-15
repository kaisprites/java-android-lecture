package classpackage;

public class CalcOverload {
	//동일한 이름의 메서드는 parameter의 종류와 수, 순서로 구분한다
	public void add () {
		System.out.println("더하기 기능");
	}
	public int add (int x) {
		return x+x;
	}
	public int add (int x, int y) {
		return x+y;
	}
	public double add (double x, int y) {
		return x+y;
	}
	public double add (int x, double y) {
		return x+y;
	}
}
