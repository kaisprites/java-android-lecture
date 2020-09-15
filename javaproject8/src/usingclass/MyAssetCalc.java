package usingclass;

import classpackage.Calc;

public class MyAssetCalc {

	public static void main(String[] args) {
		Calc cal = new Calc();
		int period = 6;
		int asset = 100000;
		int sum = cal.mult(period, asset);
		if(sum >= 500000) System.out.println((sum+150000)+"원을 받았습니다");
		else System.out.println((sum)+"원을 받았습니다");
		
		int half1 = 600000;
		int half2 = 500000;
		cal.add(half1, half2);
		
	}

}
