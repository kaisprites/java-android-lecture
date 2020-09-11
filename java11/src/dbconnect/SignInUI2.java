package dbconnect;

import javax.swing.JOptionPane;

public class SignInUI2 {

	public static void main(String[] args) throws Exception {
		String id = JOptionPane.showInputDialog("id입력");
		String pw = JOptionPane.showInputDialog("pw입력");
		String name = JOptionPane.showInputDialog("name입력");
		String tel = JOptionPane.showInputDialog("tel입력");
		MemberDAO db = new MemberDAO();
		MemberVO bag = new MemberVO();
		bag.setter(id, pw, name, tel);
		db.create(bag);
	}

}
