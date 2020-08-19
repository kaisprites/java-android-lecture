package branch;

public class Quiz3 {
	public static void main(String[] args) {
		//별 피라미드 그리기 
		//상단부의  5x5부터 그립니다.
		for(int i=0; i<5; i++) {
			for(int j=0; j<i+1; j++) { //j<1, j<2, j<3, j<4, j<5
				System.out.print("* ");
			}
			System.out.print("\n");
		}
		//하단부의 4x4를 그립니다.
		for(int i=0; i<4; i++) {
			for(int j=4; j>i; j--) { //j=4>0, j=3>0, j=2>0, j=1>0
				System.out.print("* ");
			}
			System.out.print("\n");
		}
		
		//별 피라미드 그리기
		for(int i=0; i<9; i++) {
			//(4,5)에서 위로 볼록한 절대값 모양인 y=5-|x-4|로 그립니다.
			for(int j=0; j<5-Math.abs(i-4); j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
