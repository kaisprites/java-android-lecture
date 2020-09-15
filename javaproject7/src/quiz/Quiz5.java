package quiz;

import java.util.Random;

public class Quiz5 {
	static public class Person {
		int first;
		int second;
	}
	public static void main(String[] args) {
		String[] sResidence = {"서울", "부산", "제주", "기타"};
		Random r = new Random();
		Person[] persons = new Person[100];
		//입력받기
		//객체를 생성하여 만들고 객체배열에 등록
		for(int i=0; i<100; i++) {
			Person elem = new Person(); 
			elem.first = r.nextInt(4)+1; //1,2,3,4
			elem.second = r.nextInt(5);
			persons[i] = elem;
		}
		//통계내기
		//남자=1,3, 여자=2,4 이므로 1을 더해서 2로 나눈 나머지를 취하면 남자=0, 여자=1
		//기타(3) 이상의 값이 들어오면 3으로 환산, 서울=0, 부산=1, 제주=2, 기타=3
		//배열은 자동으로 0으로 초기화되므로 바로 ++연산자를 써도 무방 
		int[][] statis = new int[2][4];
		for(Person x : persons) {
			int gender, residence;
			gender = (x.first+1)%2; 
			residence = x.second > 3 ? 3 : x.second; 
			statis[gender][residence]++;	
		}
		//출력하기
		for(int i=0; i<4; i++) {
			System.out.println(sResidence[i] + " 지역 " + (statis[0][i]+statis[1][i])
					+ "명 중 남자는 " + statis[0][i] + "명, 여자는 " + statis[1][i] + "명입니다.");
		}
	}

}
