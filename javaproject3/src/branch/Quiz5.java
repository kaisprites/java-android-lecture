package branch;

public class Quiz5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//     *
		//    ***
		//   *****
		//  ******* 를 출력
		for(int i=0; i<4; i++)
		{
			//공백: (0,3), (1,2), (2,1), (3,0): j=3-i
			for (int j=0; j<3-i; j++) {
				System.out.print("  ");
			}
			//별: (0,1), (1,3), (2,5), (3,7) j=2i+1
			for (int j=0; j<(2*i+1); j++) {
				System.out.print("* ");
			}
			//공백: (0,3), (1,2), (2,1), (3,0) j=3-i
			for (int j=0; j<3-i; j++) {
				System.out.print("  ");
			}
			System.out.println();
		}
	}

}
