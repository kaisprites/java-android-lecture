package branch;

import javax.swing.JOptionPane;

public class WhileTest {
	public static void main(String[] args) {
		
		//무한반복 y;
		while (true) {
			System.out.println("내가 계속 돌아요");
			String choice = JOptionPane.showInputDialog("계속? y/n");
			if( choice.equals("n")||choice.equals("no") )
				{
					System.out.println("종료합니다");
					System.exit(0);
				}
		}
		
//		//제한된 횟수 반복
//		int i = 0; 								//시작값
//		while(i<10) {							//조건식
//			System.out.println("내가 10번 돌아요");	//실행내용
//			i++;
//		}
	}
}
