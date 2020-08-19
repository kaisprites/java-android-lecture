package operator;

public class Operator2 {
	public static void main(String[] args) {
		
		int x = 200;
		int y = 150;
		int sum = x + y;
		int div = y / x;
		System.out.println(x + "+" + y + "=" + sum);
		//int끼리의 계산은 int
		System.out.println(x + "/" + y + "=" + div);
		//8byte double <- 4byte int
		double ddiv = y / x;
		System.out.println(x + "/" + y + "=" + ddiv);
		//double + int = double
		double div2 = (double)y/x;
		System.out.println(x + "/" + y + "=" + div2);
	}
}
