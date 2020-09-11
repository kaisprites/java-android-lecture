package crawl;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrawlFinanceJF {
	private static JTextField textField;
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		
		jf.setSize(300,600);
		jf.getContentPane().setLayout(null);
		
		//ÁÖ¿ä Ç×¸ñµéÀÇ ¹öÆ° ´©¸£¸é ÄÚµå¸¦ ÀÔ·Â
		JButton btnCode1 = new JButton("\uC0BC\uC131\uC804\uC790");
		btnCode1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("005930");
			}
		});
		btnCode1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		btnCode1.setBounds(12, 10, 260, 53);
		jf.getContentPane().add(btnCode1);
		
		JButton btnCode2 = new JButton("\uC2E0\uD48D\uC81C\uC57D");
		btnCode2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("019170");
			}
		});
		btnCode2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		btnCode2.setBounds(12, 73, 260, 53);
		jf.getContentPane().add(btnCode2);
		
		JButton btnCode3 = new JButton("\uC218\uC820\uD14D");
		btnCode3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("253840");
			}
		});
		btnCode3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		btnCode3.setBounds(12, 136, 260, 53);
		jf.getContentPane().add(btnCode3);
		
		textField = new JTextField();
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		textField.setBounds(12, 226, 260, 53);
		jf.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("code");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 199, 260, 15);
		jf.getContentPane().add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		textPane.setBounds(12, 352, 260, 199);
		jf.getContentPane().add(textPane);
		jf.setVisible(true);
		
		//Å©·Ñ¸µ ¹öÆ° ´©¸£¸é ½ÇÁ¦ Å©·Ñ¸µ ÇØ¿È
		JButton btnCrawl = new JButton("\uD06C\uB864\uB9C1");
		btnCrawl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText() == "") return;
				CrawlFinance cf = new CrawlFinance();
				String[] data = cf.crawl(textField.getText());
				String result = "ÇöÀç°¡: " + data[2] + "\n¾îÁ¦°¡: " + data[5] + "\nÃÖ°í°¡: " + data[6];
				textPane.setText(result);
			}
		});
		btnCrawl.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		btnCrawl.setBounds(12, 289, 260, 53);
		jf.getContentPane().add(btnCrawl);
	
	}
}
