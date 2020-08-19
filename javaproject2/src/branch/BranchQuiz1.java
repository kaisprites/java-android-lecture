package branch;

public class BranchQuiz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 퀴즈1: 100부터 시작해서 1까지
		//i가 100부터 시작해서 i가 0초과(1이상)인 동안 loop(i출력, i는 1씩감소)
		int i=100;
		while(i>0) {	
			System.out.println(i);
			i=i-1;
		}
		// 퀴즈2: 5부터 시작해서 10까지
		//j가 5부터 시작해서 10이하인 동안 loop(j출력, j는 1씩증가)
		int j=5;
		while(j<=10) {
			System.out.println(j);
			j=j+1;
		}
		// 퀴즈3: 1부터 시작해서 100까지, 2씩 증가하면서
		//k가 1부터 시작해서 100이하인 동안 loop(k출력, k는 2씩증가)
		int k=1;
		while(k<=100) {
			System.out.println(k);
			k=k+2;
		}
	}

}
