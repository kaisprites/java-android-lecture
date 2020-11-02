package cook;

import java.util.Scanner;

public class CookManager {
	ICook cook;
	public CookManager(String food) {
		if(food.equals("한식")) {
			cook = new KoreanCook();
		} else if(food.equals("중식")) {
			cook = new ChineseCook();
		} else {
			cook = new IndianCook();
		}
	}
	public void soup () { cook.makeSoup(); }
	public void salad () { cook.makeSalad(); }
	
	public static void main (String[] arg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("한식? 중식? 인도음식?");
		String food = sc.next();
		CookManager cm = new CookManager(food);
		cm.soup();
		cm.salad();
	}
}
