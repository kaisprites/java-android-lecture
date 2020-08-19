package branch;
public class Quiz2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 짝수단만 출력되는 구구단
		for(int i=2; i<10; i++) {
			if(i%2==1) continue; //홀수인 경우 continueD
			for(int j=1; j<10; j++) {
				System.out.println(i + " * " + j + " = " + (i*j));
			}
		}
	}
}
