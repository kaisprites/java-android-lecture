package graphic;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Ordering {
	private static JTextField quantity;
	static int idx = 0;
	static int count = 0;
	static int sum = 0;
	public static void main(String[] args) {
		String[] images = {"menu1.jpg", "menu2.png", "menu3.jpg"};
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.getContentPane().setLayout(null);
		
		quantity = new JTextField();
		quantity.setBounds(294, 10, 178, 34);
		f.getContentPane().add(quantity);
		quantity.setColumns(10);
		
		JLabel result = new JLabel("New label");
		result.setFont(new Font("휴먼매직체", Font.BOLD, 40));
		result.setBounds(12, 396, 460, 55);
		f.getContentPane().add(result);
		
		JLabel image = new JLabel("New label");
		image.setIcon(new ImageIcon(images[idx]));
		image.setBounds(12, 54, 460, 342);
		f.getContentPane().add(image);
		f.setVisible(true);
		
		JButton menu1 = new JButton("짜장");
		menu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idx=0;
				count++;
				image.setIcon(new ImageIcon(images[idx]));;
				quantity.setText(count + "개");
				sum += 5000;
				result.setText("지불할 총 금액: " + sum + "원");
			}
		});
		menu1.setBounds(12, 10, 82, 34);
		f.getContentPane().add(menu1);
		
		JButton menu2 = new JButton("짬뽕");
		menu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idx=1;
				count++;
				image.setIcon(new ImageIcon(images[idx]));;
				quantity.setText(count + "개");
				sum += 4000;
				result.setText("지불할 총 금액: " + sum + "원");
			}
		});
		menu2.setBounds(106, 10, 82, 34);
		f.getContentPane().add(menu2);
		
		JButton menu3 = new JButton("우동");
		menu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idx=2;
				count++;
				image.setIcon(new ImageIcon(images[idx]));;
				quantity.setText(count + "개");
				sum += 4500;
				result.setText("지불할 총 금액: " + sum
						
						+ "원");
			}
		});
		menu3.setBounds(200, 10, 82, 34);
		f.getContentPane().add(menu3);
		
	}
}
