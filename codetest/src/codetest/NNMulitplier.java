package codetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class NNMulitplier {
	
	public static void nnMultiplier(int a, int b, int c) {
		BigInteger result = BigInteger.ONE;
		result = result.multiply(new BigInteger(String.valueOf(a)));
		result = result.multiply(new BigInteger(String.valueOf(b)));
		result = result.multiply(new BigInteger(String.valueOf(c)));
		String resstr = result.toString();
		HashMap<Integer, Integer> resmap = new HashMap<Integer, Integer>();
		for(int i=0; i<resstr.length(); i++) {
			int t = Character.getNumericValue(resstr.charAt(i));
			if(resmap.get(t) != null) {
				resmap.put(t, resmap.get(t)+1);
			} else {
				resmap.put(t, 1);
			}
		}
		System.out.println(resstr);
		for (int i=0; i<10; i++) {
			Integer t = resmap.get(i);
			if(t == null) t = 0;
			System.out.println(i + ": " + t);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("NNMultiplier.txt");
		Scanner sc = new Scanner(f);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		nnMultiplier(a, b, c);
		sc.close();
	}

}
