package dbconnect;

import javax.swing.JOptionPane;

public class UpdateUI {

	public static void main(String[] args) throws Exception {
		String key = JOptionPane.showInputDialog("Ű:");
		String col = JOptionPane.showInputDialog("������ �� �̸�:");
		String context = JOptionPane.showInputDialog("������ ����:");
		
		MemberDAO db = new MemberDAO();
		db.update(context, key);
	}

}
