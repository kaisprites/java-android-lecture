package dbconnect;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BBSCrudUI {
	private static JTextField tfNo;
	private static JTextField tfTitle;
	private static JTextField tfWriter;

	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setSize(500,800);
		j.getContentPane().setLayout(null);
		
		tfNo = new JTextField();
		tfNo.setBounds(77, 10, 395, 21);
		j.getContentPane().add(tfNo);
		tfNo.setColumns(10);
		
		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(77, 42, 395, 21);
		j.getContentPane().add(tfTitle);
		
		tfWriter = new JTextField();
		tfWriter.setColumns(10);
		tfWriter.setBounds(77, 73, 395, 21);
		j.getContentPane().add(tfWriter);
		
		JTextPane tfContent = new JTextPane();
		tfContent.setBounds(77, 104, 395, 260);
		j.getContentPane().add(tfContent);
		
		JLabel lblNewLabel = new JLabel("No.");
		lblNewLabel.setBounds(8, 13, 57, 15);
		j.getContentPane().add(lblNewLabel);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(8, 45, 57, 15);
		j.getContentPane().add(lblTitle);
		
		JLabel lblWriter = new JLabel("Writer");
		lblWriter.setBounds(8, 76, 57, 15);
		j.getContentPane().add(lblWriter);
		
		JLabel lblContent = new JLabel("Content");
		lblContent.setBounds(8, 104, 57, 15);
		j.getContentPane().add(lblContent);
		
		//CrudUI의 Write버튼 구현
		JButton btnCreate = new JButton("Write");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BBSVO bag = new BBSVO();
				bag.setNo(Integer.parseInt(tfNo.getText()));
				bag.setTitle(tfTitle.getText());
				bag.setWriter(tfWriter.getText());
				bag.setContent(tfContent.getText());
				
				BBSDAO dao = new BBSDAO();
				try {
					dao.create(bag);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCreate.setBounds(32, 374, 69, 21);
		j.getContentPane().add(btnCreate);
		
		//CrudUI의 Search 버튼 구현
		JButton btnRead = new JButton("Search");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = tfNo.getText();
				BBSDAO dao = new BBSDAO();
				try {
					BBSVO bag = dao.read(no);
					tfNo.setText(String.valueOf(bag.getNo()));
					tfWriter.setText(bag.getWriter());
					tfTitle.setText(bag.getTitle());
					tfContent.setText(bag.getContent());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRead.setBounds(113, 374, 78, 21);
		j.getContentPane().add(btnRead);
		
		//CrudUI의 Modify 버튼 구현
		JButton btnUpdate = new JButton("Modify");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BBSVO bag = new BBSVO();
				bag.setNo(Integer.parseInt(tfNo.getText()));
				bag.setTitle(tfTitle.getText());
				bag.setContent(tfContent.getText());
				
				BBSDAO dao = new BBSDAO();
				try {
					dao.update(bag);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(288, 374, 78, 21);
		j.getContentPane().add(btnUpdate);
		
		//CrudUI의 Delete 버튼 구현
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = tfNo.getText();
				
				BBSDAO dao = new BBSDAO();
				try {
					dao.delete(no);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(378, 374, 78, 21);
		j.getContentPane().add(btnDelete);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 406, 460, 345);
		j.getContentPane().add(textPane);
		
		JButton btnList = new JButton("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BBSDAO dao = new BBSDAO();
				ArrayList<BBSVO> list;
				try {
					list = dao.all();
					String result = "";
					for(int i=0; i<list.size(); i++) {
						BBSVO bag = list.get(i);
						String temp = bag.getNo() + ", " + bag.getTitle() + ", " + bag.getWriter() + ", " + bag.getContent() + "\n";
						result = result.concat(temp);
					}
					textPane.setText(result);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnList.setBounds(203, 374, 78, 21);
		j.getContentPane().add(btnList);
		j.setVisible(true);
	}
}
