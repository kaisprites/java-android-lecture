package basicio;

import javax.swing.JOptionPane;

public class DialogueTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String c = JOptionPane.showInputDialog("세번째 숫자:");
		String d = JOptionPane.showInputDialog("문자:");
		for(int i=0; i<Integer.parseInt(c); i++) {
			System.out.print(d);
		}
	}

}
