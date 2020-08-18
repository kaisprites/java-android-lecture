package operator;

import javax.swing.JOptionPane;

public class BaseIO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ctrl alt arrow = 한 줄 복사
		// alt arrow = 한 줄 이동
		
		String a = JOptionPane.showInputDialog("첫번째 수 입력");
		String b = JOptionPane.showInputDialog("두번째 수 입력");
		int sum = Integer.parseInt(a) + Integer.parseInt(b);
		System.out.println(a + " + " + b + " = " + sum);
	}

}
	