package codetest;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/* 수 입력받아 팩토리얼 출력 */
public class Factorial {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("수 입력: ");
			int target = sc.nextInt();
			if(target <= 0) break;
			BigInteger fac = new BigInteger("1");
			//재귀는 메모리 낭비가 크므로 반복문으로 구현
			for(int i=1; i<=target; i++)
				fac = fac.multiply(new BigInteger(String.valueOf(i)));
			NumberFormat formatter = new DecimalFormat("0.######E0", DecimalFormatSymbols.getInstance(Locale.ROOT));
			String str = fac.toString();
			if (str.length() > 10) str = formatter.format(fac);
			System.out.println(target + "! = " + str);
		}
		sc.close();
	}

}
