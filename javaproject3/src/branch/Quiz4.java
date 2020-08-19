package branch;

public class Quiz4 {

	public static void main(String[] args) {
		// 단수<=곱하는 수일때만 출력 
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(i<j) break; //단수>곱하는 수이므로 break
				System.out.println(i + " * " + j + " = " + (i*j));
			}
		}
	}

}
