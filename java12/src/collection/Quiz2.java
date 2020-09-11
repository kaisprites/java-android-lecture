package collection;

import java.util.LinkedList;

public class Quiz2 {

	public static void main(String[] args) {
		//하루에 시험 한개씩 보고 이미 본것은 삭제
		LinkedList<String> test = new LinkedList<String>();
		test.add("국어");
		test.add("수학");
		test.add("영어");
		test.add("컴퓨터");
		System.out.print("전체 시험볼 과목: ");
		System.out.println(test);
		for(int i=0; i<3; i++) {
			test.remove();
			System.out.print((i+1) + "일차 시험본 후 남은  과목: ");
			System.out.println(test);
		}
	}

}
