package guiswing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyGUI {

	public static void main(String[] args) {
		//Java is Object-oriented Programming language
		//ctrl+shift+o: 자동 import
		//창
		JFrame fr = new JFrame();
		//버튼
		JButton b1 = new JButton();
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(fr, "나를 눌러요를 눌렀군요");
			}
		});
		JButton b2 = new JButton();
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(fr, "나도 눌러요를 눌렀습니다");
			}
		});
		JButton b3 = new JButton();
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(fr, "그림을 눌렀습니다");}
		});
		//이미지
		String imgstr = "sky.jpg";
		ImageIcon img = new ImageIcon(imgstr);
		//버튼의 표시
		b1.setText("나를 눌러요");
		b2.setText("나도 눌러요");
		b3.setIcon(img);
		//버튼을 창에 추가		
		fr.getContentPane().add(b1);
		fr.getContentPane().add(b2);
		fr.getContentPane().add(b3);
		//flow
		FlowLayout flow = new FlowLayout();
		fr.getContentPane().setLayout(flow);
		//창을 보이게(맨 아래에 두어야 함)
		fr.setSize(1000, 500);
		fr.setVisible(true);
	}
}
