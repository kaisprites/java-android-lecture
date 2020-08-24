package guiswing;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUICalc {
	public static void main(String[] args) {
		JFrame j = new JFrame();
		
		//이미지
		ImageIcon imgic = new ImageIcon("calc.png");
		JLabel img = new JLabel();
		img.setIcon(imgic);
		//텍스트
		JLabel text1 = new JLabel();
		text1.setFont(new Font("궁서", Font.PLAIN, 60));
		text1.setText("숫자1");
		JLabel text2 = new JLabel();
		text2.setFont(new Font("궁서", Font.PLAIN, 60));
		text2.setText("숫자2");
		JLabel text3 = new JLabel();
		text3.setFont(new Font("궁서", Font.PLAIN, 60));
		//텍스트 입력상자
		JTextField area1 = new JTextField();
		area1.setColumns(4);
		area1.setFont(new Font("궁서", Font.PLAIN, 60));
		area1.setBackground(Color.YELLOW);
		JTextField area2 = new JTextField();
		area2.setColumns(4);
		area2.setFont(new Font("궁서", Font.PLAIN, 60));
		area2.setBackground(Color.YELLOW);
		//버튼: 텍스트 입력상자의 두 string값을 가져와 int로 변환해 연산한다
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(area1.getText());
				int b = Integer.parseInt(area2.getText());
				String result = String.valueOf(a+b);
				text3.setText(result);
			}
		});
		button.setForeground(Color.RED);
		button.setBackground(Color.BLUE);
		button.setFont(new Font("굴림", Font.PLAIN, 50));
		button.setText("+");
		JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(area1.getText());
				int b = Integer.parseInt(area2.getText());
				String result = String.valueOf(a-b);
				text3.setText(result);
			}
		});
		button_1.setText("-");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("굴림", Font.PLAIN, 50));
		button_1.setBackground(Color.BLUE);
		
		
		JButton button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(area1.getText());
				int b = Integer.parseInt(area2.getText());
				String result = String.valueOf(a*b);
				text3.setText(result);
			}
		});
		button_2.setText("*");
		button_2.setForeground(Color.RED);
		button_2.setFont(new Font("굴림", Font.PLAIN, 50));
		button_2.setBackground(Color.BLUE);
		
		
		JButton button_3 = new JButton();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(area1.getText());
				int b = Integer.parseInt(area2.getText());
				String result = String.valueOf((double)a/b);
				text3.setText(result);
			}
		});
		button_3.setText("/");
		button_3.setForeground(Color.RED);
		button_3.setFont(new Font("굴림", Font.PLAIN, 50));
		button_3.setBackground(Color.BLUE);
		
		//플로우 레이아웃
		FlowLayout flow = new FlowLayout();
		j.getContentPane().setLayout(flow);
		
		j.setSize(300,750);
		j.getContentPane().add(img);
		j.getContentPane().add(text1);
		j.getContentPane().add(area1);
		j.getContentPane().add(text2);
		j.getContentPane().add(area2);
		j.getContentPane().add(button);
		j.getContentPane().add(button_1);
		j.getContentPane().add(button_2);
		j.getContentPane().add(button_3);
		j.getContentPane().add(text3);
		j.setVisible(true);
		
		
		
		
		
		

	}
}
