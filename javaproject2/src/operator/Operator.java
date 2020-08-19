package operator;

public class Operator {
	public static void main(String[] args) {
		int x = 200;
		int y = 150;
		System.out.println(x + "+" + y + "=" + (x+y));
		System.out.println(x + "-" + y + "=" + (x-y));
		System.out.println(x + "*" + y + "=" + (x*y));
		System.out.println(x + "/" + y + "=" + (x/y));
		//System.out.println(x + "/" + y + "=" + float(x/y)); error
		System.out.println(x + "/" + y + "=" + ((float)x/(float)y));
		System.out.println(x + "%" + y + "=" + (x%y));
	}
}
