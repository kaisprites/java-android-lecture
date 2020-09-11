package method;

public class Shop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc cal = new Calc();
		cal.color = "red";
		cal.price = 5000;
		cal.size = 11;
		int jcount = 5;
		int ccount = 3;
		int sum = cal.plus(jcount, ccount);
		int sum2 = cal.mult(sum, 3000);
		System.out.println("지불금액: " + sum2 + "원");
		
		int jprice = cal.mult(5, 3000);
		int cprice = cal.mult(3, 2000);
		System.out.println("쥬스가격은 " + jprice + "원");
		System.out.println("커피가격은 " + cprice + "원");
		
		int interval = cal.minus(jprice, cprice);
		System.out.println("가격차이는 " + interval + "원");
	}

}
