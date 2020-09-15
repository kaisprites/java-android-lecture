package usingclass;

import classpackage.CalcOverload;

public class UsingCalcOverload {

	public static void main(String[] args) {
		CalcOverload cal = new CalcOverload();
		cal.add();
		System.out.println(cal.add(100));
		System.out.println(cal.add(100, 200));
		System.out.println(cal.add(11.2,3));
		System.out.println(cal.add(1,12.3));
	}

}
