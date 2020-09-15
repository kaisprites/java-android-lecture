package array;

public class TwoDimensionArray2 {

	public static void main(String[] args) {
		// 배열의 각원소배열 길이가 다른 2차원배열
			int[][] grade = new int[4][];
			
			int kor[] = {50,60,70,80,90};
			int math[] = {66,77,88};
			int eng[] = {90,80,70,60};
			int sci[] = {77,100};
			grade[0] = kor;
			grade[1] = math;
			grade[2] = eng;
			grade[3] = sci;
			
			for (int i = 0; i < grade.length; i++) {
				for (int j = 0; j < grade[i].length; j++) {
					System.out.print(grade[i][j]+"\t");
				}
				System.out.println();
			}
	}

}
