package usingclass;

import classpackage.Calc;

public class UsingCalcinDomestic {

	public static void main(String[] args) {
		Calc cal = new Calc();
		
		int bucket = 2;
		int flower = 5;
		cal.add(bucket, flower);
		//void 메서드는 결과를 출력할 수 없고 변수에 넣을 수도 없음
		
		int price = 15000;
		int sum = cal.mult(bucket, price);
		if(sum>=25000)
			System.out.println("결제금액: " + (sum-3000));
		else
			System.out.println("결제금액: " + sum);
	}

}
