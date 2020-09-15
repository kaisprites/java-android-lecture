package array;

public class CopyVar {

	public static void main(String[] args) {
		// 기본형변수의 복사;
		int x1 = 300;
		int y1 = x1;
		y1++;
		System.out.println(x1 + "\t" + y1);
		
		// String은 string literal을 직접 수정할 방법이 없기 때문에 기본형처럼 보이지만 엄밀히는 참조형이다.
		//(모든 String메소드는 string literal을 직접 수정하지 않고 String객체를 새로 생성한다)
		String x2 = "abc";
		String y2 = x2;
		String z2 = x2.substring(0);
		y2 = y2.replace('b','c');
		z2 = z2.concat("e");
		System.out.println(x2 + "\t" + y2 + "\t" + z2);
		
		// String literal은 String Pool이라는 힙 내부의 별도의 영역에 저장
		// new(String literal)은 다른 객체들과 마찬가지로 힙 영역에 저장
		// 물론 new로 생성된 String 객체들도 그 내용은 String Pool 내부의 리터럴을 가리킨다
		String j = "abc";
		String k = "abc";
		System.out.println(k == j);
		String l = new String("abc");
		String m = new String("abc");
		System.out.println(m == l);
		
		// 참조형변수의 복사;
		int[] x3 = {1,2,3,4,5};
		int[] y3 = x3;			//shallow copy
		int[] z3 = x3.clone();	//deep copy
		y3[3] = 6;
		z3[3] = 9;
		for(int i=0; i<5; i++) {System.out.print(x3[i] + "\t");} System.out.println();
		for(int i=0; i<5; i++) {System.out.print(y3[i] + "\t");} System.out.println();
		for(int i=0; i<5; i++) {System.out.print(z3[i] + "\t");} System.out.println();
		
		// 2차원 배열도 clone 되나요?
		int[][] x4 = {{1,2,3},{4,5,6}};
		int[][] y4 = x4.clone();
		y4[1][2] = 0;
		for(int i=0; i<6; i++) {System.out.print(y4[i/3][i%3] + "\t");} System.out.println();
		for(int i=0; i<6; i++) {System.out.print(y4[i/3][i%3] + "\t");} System.out.println();
		// 아니오......
		// 2차원배열의 deep copy는 따로 메서드를 만들어줄 필요가 있다...
	}

}
