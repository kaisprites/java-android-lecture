package sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

public class MyWindow {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(500,500);
		
		JButton btnNewButton = new JButton("나를 눌러줘");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setBackground(Math.random()>0.5?Color.BLUE:Color.RED);
			}
		});
		f.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("왼쪽");
		f.getContentPane().add(btnNewButton_1, BorderLayout.WEST);
		
		JButton btnNewButton_2 = new JButton("위쪽");
		f.getContentPane().add(btnNewButton_2, BorderLayout.NORTH);
		
		JButton btnNewButton_3 = new JButton("오늘쪽");
		f.getContentPane().add(btnNewButton_3, BorderLayout.EAST);
		
		JButton btnNewButton_4 = new JButton("아래쪽");
		f.getContentPane().add(btnNewButton_4, BorderLayout.SOUTH);;
		f.setVisible(true);;
		
	}

}
