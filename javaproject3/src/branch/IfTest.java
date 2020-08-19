package branch;

import javax.swing.JOptionPane;

public class IfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5번 입력받아 긍정/부정/잘모르겠음 횟수를 출력
		//수정: 종료 입력받으면 종료, 무한루프
		
		int ok=0,no=0,etc=0;
		for (;;) {
			String data = JOptionPane.showInputDialog("ok/no/exit?");
			
			if(data.equals("ok")) {
				System.out.println("긍정");
				ok++;
			} else if(data.equals("no")) {
				System.out.println("부정");
				no++;
			} else if(data.equals("exit")) {
				break;
			} else {
				System.out.println("잘모르겠음");
				etc++;
			}
		}
		System.out.println("ok: "+ok+" no: "+no+" etc: "+etc);
	}

}
