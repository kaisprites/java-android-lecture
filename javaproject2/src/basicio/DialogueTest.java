package basicio;

import javax.swing.JOptionPane;

public class DialogueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = JOptionPane.showInputDialog("첫번째 숫자:");
		String b = JOptionPane.showInputDialog("두번째 숫자:");
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		JOptionPane.showMessageDialog(null, aa+bb);
		if(aa == 5 && bb == 1000)
		{
			for(int i=5; i<1001; i++)
			{
				System.out.print(i + " ");
			}
		}
		System.out.println("");
	}
}
