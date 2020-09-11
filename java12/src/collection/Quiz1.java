package collection;

import java.util.ArrayList;

public class Quiz1 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList ski = new ArrayList();
		
		//순서대로 집어넣기
		ski.add("박스키");
		ski.add("송스키");
		ski.add("김스키");
		ski.add("정스키");
		for (int i = 0; i < ski.size(); i++) {
			System.out.println((i+1) + "등: " + ski.get(i));
		}
		System.out.println("2등이 반칙해서 탈락");
		ski.remove(1);	//리스트에서 지우기
		for (int i = 0; i < ski.size(); i++) {
			System.out.println((i+1) + "등: " + ski.get(i));
		}
	}
}
