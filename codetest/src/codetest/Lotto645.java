package codetest;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto645 {
	public static void main(String[] args) {
		Set<Integer> h = new HashSet<Integer>();
		while(h.size() < 6) {
			Random r = new Random();
			h.add(r.nextInt(45)+1);
		}
		System.out.println(h);
	}
}
