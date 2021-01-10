package codetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringRepeater {
	
	public static String stringRepeater(int count, String str) {
		StringBuffer result = new StringBuffer("");
		for(int i=0; i<str.length(); i++) {
			String strFrag = str.substring(i,i+1);
			for (int j=0; j<count; j++) {
				result.append(strFrag);
			}
		}
		return result.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("StringRepeater.txt");
		Scanner sc = new Scanner(f);
		while (true) {
			try {
				int count = sc.nextInt();
				String str = sc.nextLine().substring(1);
				System.out.println(stringRepeater(count, str));
			} catch (NoSuchElementException e) {
				break;
			}
		}
		sc.close();
	}

}
