package array;

public class Array1 {

	public static void main(String[] args) {
		int[] grade = new int [1000];
		// grade[0], grade[1], grade[2], ..., grade[999] = grade[n-1]
		System.out.println(grade); //배열의 주소가 출력됨
		grade[0] = 100;
		grade[40] = 200;
		grade[999] = 1000;
		//grade[1000] does not exist
		
		System.out.println("첫번째 값: "+grade[0]);
		System.out.println("41번째 값: "+grade[40]);
		System.out.println("마지막 값: "+grade[999]);
		System.out.println("초기화 안한 값: "+ (++grade[499]));
		for (int i = 0; i < grade.length; i++) {
			if(grade[i]!=0) System.out.print(i + " ");
		}
		//자바는 0이나 false로 배열을 자동초기화한다
		
		String[] names = new String [1000];
		System.out.println(names[0]);
		System.out.println(names.length);
		System.out.println(names[names.length-1]);
		//String배열은 null로 초기화됨
	}
}
