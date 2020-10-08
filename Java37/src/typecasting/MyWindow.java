package typecasting;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyWindow {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("나의 윈도우");
		f.setSize(400, 400);;
		
		JButton b = new JButton("버튼");
		JLabel l = new JLabel("라벨");
		JPanel p = new JPanel();
		p.setBackground(Color.yellow);
		f.setLayout(new FlowLayout());
		f.add(b);
		f.add(l);
		f.add(p);
	
		Font font = new Font("궁서", Font.BOLD, 50);
		b.setFont(font);
		l.setFont(font);
		f.setVisible(true);
	}

}
