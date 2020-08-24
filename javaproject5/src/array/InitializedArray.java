package array;

public class InitializedArray {

	public static void main(String[] args) {
		//초기값이 정해져 있지 않은 배열
		int[] grade = new int[10];
		grade[0] = 100;
		grade[9] = 100;
		for (int i = 0; i < grade.length; i++) {
			System.out.println("i: " + grade[i]);
		}
		
		//iterator for: 반복가능한 객체에 대해서
		//사용할 수 있다.
		for (int x : grade) {
			System.out.println("i: " + x);
		}
		
		//초기값으로 초기화한 배열
		int[] grade2 = {100, 200, 300};
		for (int i = 0; grade2[i] < 300; i++) {
			System.out.println("i :"+ grade2[i]);
		}
	}

}
