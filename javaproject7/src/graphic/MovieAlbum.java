package graphic;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.sun.prism.Graphics;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.lang.Thread;

public class MovieAlbum {
	static int idx = 1;

	public static void main(String[] args) {
		String[] titles = {"다만악에서", "오케이마담", "테넷", "소녀시대", "강철비"};
		String[] images = {"mv1.jpg", "mv2.jpg", "java09.jpg", "mv4.jpg", "mv5.jpg"};
		String[] directors = {"아무개", "어쩌구", "경악", "이런저런", "1234"};
		double[] rates = {9.87,8.76,8.55,9.42,5.19};
		
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.GREEN);
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 484, 57);
		f.getContentPane().add(panel);
		
		JLabel title = new JLabel(titles[idx]);
		panel.add(title);
		title.setBackground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("굴림", Font.BOLD, 40));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(58, 67, 362, 384);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel img = new JLabel("New label");
		img.setIcon(new ImageIcon("d:\\minseok\\workspace\\javaproject7\\java09.jpg"));
		img.setBounds(12, 71, 163, 267);
		panel_1.add(img);
		
		JLabel lblNewLabel_2 = new JLabel("감독");
		lblNewLabel_2.setBounds(187, 65, 109, 32);
		panel_1.add(lblNewLabel_2);
		
		JLabel director = new JLabel(directors[idx]);
		director.setBounds(187, 107, 163, 46);
		panel_1.add(director);
		
		JLabel lblNewLabel_2_1 = new JLabel("평점");
		lblNewLabel_2_1.setBounds(187, 217, 109, 32);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel rate = new JLabel(rates[idx] + "");
		rate.setBounds(187, 259, 163, 46);
		panel_1.add(rate);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idx=(idx+4)%5;
				title.setText(titles[idx]);
				ImageIcon icon = new ImageIcon(images[idx]);
				img.setIcon(icon);
				director.setText(directors[idx]);
				rate.setText(rates[idx]+"");
			}
		});
		btnNewButton.setBounds(0, 214, 53, 48);
		f.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idx=(idx+1)%5;
				title.setText(titles[idx]);
				ImageIcon icon = new ImageIcon("d:\\minseok\\workspace\\javaproject7\\"+images[idx]);
				img.setIcon(icon);
				director.setText(directors[idx]);
				rate.setText(rates[idx]+"");
			}
		});
		btnNewButton_1.setBounds(431, 214, 53, 48);
		f.getContentPane().add(btnNewButton_1);
		
		
		
		
	}
}
