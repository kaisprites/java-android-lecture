package dbconnect;

import javax.swing.JOptionPane;

public class DeleteUI {

	public static void main(String[] args) throws Exception {
		String id = JOptionPane.showInputDialog("������ id:");
		
		MemberDAO db = new MemberDAO();
		db.delete(id);
	}

}
