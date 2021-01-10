package codetest;

import java.io.File;
import java.util.Scanner;

public class NumberAdder {
	
	public static int numberAdder (int count, String numstr) {
		int sum = 0;
		for(int i=0; i<count; i++) {
			sum += Character.getNumericValue(numstr.charAt(i));
		}
		return sum;
				
	}

	public static void main(String[] args) throws Exception {
		File f = new File("NumberAdder.txt");
		Scanner sc = new Scanner(f);
		int count = Integer.parseInt(sc.nextLine());
		String numstr = sc.nextLine();
		System.out.println(numberAdder(count, numstr));
	}

}
