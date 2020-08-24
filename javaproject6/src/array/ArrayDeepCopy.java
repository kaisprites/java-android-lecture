package array;

public class ArrayDeepCopy {

	public static void main(String[] args) {
		int[] grade1 = {100, 99, 77, 87, 66};
		int[] grade2 = grade1.clone();
		int sum1 = 0;
		int sum2 = 0;
		int changed = 0;
		String[] gradeName = {"국어", "수학", "과학", "컴퓨터", "영어"};
		
		//점수변경
		grade2[2] = 44;
		grade2[4] = 55;
		
		//점수부터 출력
		for(int x : grade1) { System.out.print(x + " "); sum1+=x; }
		System.out.println();
		for(int x : grade2) { System.out.print(x + " "); sum2+=x; }
		System.out.println();
		
		//점수가 변경되었으면 변경된 수++, 변경되지 않았으면 과목의 이름을 지운다(나중에 식별함)
		for(int i=0; i<grade1.length; i++) {
			if(grade1[i] != grade2[i]) changed++;
			else gradeName[i] = "";
		}
		
		//출력 (평균=합계/5이므로 합계로 비교해도 동일)
		System.out.println("점수가 변경된 과목의 수: " + changed);
		System.out.println("평균이 더 높은 학기: " + (sum1>sum2?"1학기":(sum1<sum2?"2학기":"평균이 같음")));
		System.out.print("점수가 변경된 과목명: ");
		for(String x : gradeName) if(x!="") System.out.print(x + " ");
		//아까 지우지 않은 과목=변경된 과목이므로 그대로 출력한다
	}
}
