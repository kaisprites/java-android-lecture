package array;

public class TwoDimensionedArray {

	public static void main(String[] args) {
		// 배열을 선언하고 공간이 할당되었다.
		int[][] seat = new int[3][10];
		
		System.out.println(seat);
		//	0	1	2	3	4	5	6	7	8	9
		//0	0	0	0	0	0	0	0	0	0	0
		//1	0	0	0	0	0	0	0	0	0	0
		//2	0	0	0	0	0	0	0	0	0	0
		
		seat[0][0] = 1;
		seat[0][4] = 1;
		seat[2][4] = 1;
		seat[1][2] = 1;
		seat[2][1] = 1;
		
		for(int i=0; i<30; i++) {
			System.out.print(seat[i/10][i%10]);
			if(i%10 == 9) System.out.println();
		}
		
		int[][] seat2 = new int[3][];
		seat2[0] = new int[3];
		seat2[1] = new int[4];
		seat2[2] = new int [5];
		for(int i=0; i<3; i++) {
			for(int j=0; j<seat2[i].length; j++) {
				System.out.print(seat2[i][j]);
			}
			System.out.println();
		}
	}

}
