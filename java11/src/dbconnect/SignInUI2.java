package dbconnect;

import javax.swing.JOptionPane;

public class SignInUI2 {

	public static void main(String[] args) throws Exception {
		String id = JOptionPane.showInputDialog("id�Է�");
		String pw = JOptionPane.showInputDialog("pw�Է�");
		String name = JOptionPane.showInputDialog("name�Է�");
		String tel = JOptionPane.showInputDialog("tel�Է�");
		MemberDAO db = new MemberDAO();
		MemberVO bag = new MemberVO();
		bag.setter(id, pw, name, tel);
		db.create(bag);
	}

}
