package branch;

import javax.swing.JOptionPane;

public class IfTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력을 받아 정답이면 축하합니다! 하고 종료 아니면 계속 입력받아 확인
		int target = 88; //정답!
		int count = 0;
		
		//무한루프(정답을 입력받을 때까지)
		for (; true ;) {
			//숫자 입력받아서 int로 변환
			String input = JOptionPane.showInputDialog("숫자를 입력하세요");
			int inputint = Integer.parseInt(input);
			
			//입력받은 숫자가 정답보다 크면 "너무 커요!" 출력하고 오답횟수 1회 증가
			if(inputint > target) {
				System.out.println("너무 커요!");
				count ++;
			}
			
			//입력받은 숫자가 정답보다 작으면 "너무 작아요!" 출력하고 오답횟수 1회 증가
			else if(inputint < target) {
				System.out.println("너무 작아요!");
				count ++;
			}
			
			//아닐 경우 루프 해소
			else break;
				
		}
		//정답 출력
		System.out.println("정답!\n틀린 횟수: " + count);
	}

}
