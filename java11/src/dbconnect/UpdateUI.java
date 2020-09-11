package dbconnect;

import javax.swing.JOptionPane;

public class UpdateUI {

	public static void main(String[] args) throws Exception {
		String key = JOptionPane.showInputDialog("키:");
		String col = JOptionPane.showInputDialog("변경할 행 이름:");
		String context = JOptionPane.showInputDialog("변경할 내용:");
		
		MemberDAO db = new MemberDAO();
		db.update(context, key);
	}

}
