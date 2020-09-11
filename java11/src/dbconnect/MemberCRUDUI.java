package dbconnect;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberCRUDUI {
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;

	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		f.setSize(500, 600);
		f.getContentPane().setLayout(null);
		
		t1 = new JTextField();
		t1.setBounds(128, 10, 344, 21);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(128, 41, 344, 21);
		f.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(128, 72, 344, 21);
		
		f.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(128, 103, 344, 21);
		f.getContentPane().add(t4);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(12, 10, 101, 21);
		f.getContentPane().add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setBounds(12, 41, 101, 21);
		f.getContentPane().add(lblPw);
		
		JLabel lblNewLabel_1_1 = new JLabel("TEL");
		lblNewLabel_1_1.setBounds(12, 103, 101, 21);
		f.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(12, 72, 101, 21);
		f.getContentPane().add(lblNewLabel_2);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();
				
				MemberDAO db = new MemberDAO();
				
				String[] argv = {id, pw, name, tel};
				try {
					db.create(argv);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnCreate.setBounds(16, 151, 97, 23);
		f.getContentPane().add(btnCreate);
		
		//레이블 (로그인 성공/실패시 화면에 표시)
		JLabel labelk = new JLabel();
		labelk.setBounds(116, 181, 97, 23);
		f.getContentPane().add(labelk);
		
		//로그인 버튼
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pw = t2.getText();
				
				MemberDAO db = new MemberDAO();
				
				try {
					//read에 성공하면 true 반환하고 로그인 성공
					if(db.read(id, pw)) labelk.setText("로그인 성공"); 
					else labelk.setText("로그인 실패");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnLogin.setBounds(16, 181, 97, 23);
		f.getContentPane().add(btnLogin);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				String pw = t2.getText();
				MemberDAO db = new MemberDAO();
				try {
					MemberVO bag = db.read(id);
					t1.setText(bag.getId());
					t2.setText(bag.getPw());
					t3.setText(bag.getName());
					t4.setText(bag.getTel());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRead.setBounds(140, 151, 97, 23);
		f.getContentPane().add(btnRead);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = t1.getText();
				String context = t4.getText();
				
				MemberDAO db = new MemberDAO();
				
				try {
					db.update(context, key);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(257, 151, 97, 23);
		f.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = t1.getText();
				MemberDAO db = new MemberDAO();
				try {
					db.delete(id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(375, 151, 97, 23);
		f.getContentPane().add(btnDelete);;
		f.setVisible(true);
	}
}
