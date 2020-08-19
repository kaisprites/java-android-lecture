package branch;

public class Condition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 조건이 여러개일 때 if else if else vs. if if if
		int score = 88;
		if (score >= 90) {
			System.out.println("A");
		}
		if (score >= 80) {
			System.out.println("B");
		}
		if (score >= 70) {
			System.out.println("C");
		}
		// 각 if를 모두 검사하므로 출력은 "B \n C"

		if (score >= 90) {
			System.out.println("A");
		}
		else if (score >= 80) {
			System.out.println("B");
		}
		else if (score >= 70){
			System.out.println("C");
		}
		// else에 의해 조건이 참인 if를 실행하고 나머지는 생략, 출력은 "B"
	}

}
