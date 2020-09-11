package busscript;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.CardLayout;
import javax.swing.JScrollPane;

abstract class MyListener implements ActionListener {
	int idx;
	public MyListener(int b) {
		idx = b;
	}
	public MyListener() {
		idx = 0;
	}
	abstract public void actionPerformed(ActionEvent e);
}

public class Location {
	private static JTextField tfOrigin;
	private static JTextField tfDest;
	static Color c = new Color(104, 179, 206);
	
	static CardLayout card = new CardLayout();
	static String[] mainLocation = {"¼­¿ï°æºÎ", "¼¾Æ®·²½ÃÆ¼(¼­¿ï)", "±¤ÁÖ(À¯½ºÄù¾î)", "ºÎ»ê", "ºÎ»ê»ç»ó", "µ¿¼­¿ï", "´ëÀüº¹ÇÕ", "ÀüÁÖ", "À¯¼º", "Ãµ¾È", "µ¿´ë±¸"};
	static ArrayList<String> allLocation = new ArrayList<String>();
	static ArrayList<String> seoulLocation = new ArrayList<String>();
	static ArrayList<String> incheonLocation = new ArrayList<String>();
	static ArrayList<String> kangwonLocation = new ArrayList<String>();
	static ArrayList<String> daejeonLocation = new ArrayList<String>();
	static ArrayList<String> chungbukLocation = new ArrayList<String>();
	static ArrayList<String> gwangjuLocation = new ArrayList<String>();
	static ArrayList<String> jeonbukLocation = new ArrayList<String>();
	static ArrayList<String> busanLocation = new ArrayList<String>();
	static ArrayList<String> daeguLocation = new ArrayList<String>();
	static int pointer = 0;
	
	JPanel panel1;
	JPanel parentPanel;
	
	public Location (JPanel parentPanel) throws Exception {
		JFrame jf = new JFrame();
		jf.getContentPane().setBackground(Color.WHITE);
		jf.setSize(800, 600);
		jf.getContentPane().setLayout(null);
		
		setTerminalArray();
		
		tfOrigin = new JTextField();
		tfOrigin.setEditable(false);
		tfOrigin.setBackground(Color.WHITE);
		tfOrigin.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 36));
		tfOrigin.setBounds(12, 91, 363, 73);
		jf.getContentPane().add(tfOrigin);
		tfOrigin.setColumns(10);
		tfOrigin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pointer = 0;
				tfOrigin.setBackground(Color.WHITE);
				tfDest.setBackground(Color.LIGHT_GRAY);
			};
		});
		
		tfDest = new JTextField();
		tfDest.setEditable(false);
		tfDest.setBackground(Color.LIGHT_GRAY);
		tfDest.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 36));
		tfDest.setColumns(10);
		tfDest.setBounds(409, 91, 363, 73);
		jf.getContentPane().add(tfDest);
		tfDest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pointer = 1;
				tfOrigin.setBackground(Color.LIGHT_GRAY);
				tfDest.setBackground(Color.WHITE);
			};
		});
		
		panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(12, 217, 760, 80);
		jf.getContentPane().add(panel1);
		this.parentPanel = parentPanel; 
		
		JButton[] btnMainLocation = new JButton[mainLocation.length];
		for(int i=0; i<mainLocation.length; i++) {
			btnMainLocation[i] = new JButton(mainLocation[i]);
			btnMainLocation[i].setBackground(Color.WHITE);
			btnMainLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnMainLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(mainLocation[idx]);
					else tfDest.setText(mainLocation[idx]);
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			panel1.add(btnMainLocation[i]);
		}
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(12, 347, 254, 178);
		jf.getContentPane().add(panel2);
		
		JScrollPane spTerminalCards = new JScrollPane();
		spTerminalCards.setBounds(274, 307, 498, 186);
		spTerminalCards.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		spTerminalCards.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spTerminalCards.getVerticalScrollBar().setUnitIncrement(16);
		jf.getContentPane().add(spTerminalCards);
		
		card = new CardLayout();
		JPanel pnTerminalCards = new JPanel();
		pnTerminalCards.setBackground(Color.WHITE);
		pnTerminalCards.setLayout(card);
		Dimension size = new Dimension(480, 1600);
		pnTerminalCards.setPreferredSize(size);
		spTerminalCards.setViewportView(pnTerminalCards);
		
		//¸ðµç Á¤·ùÀå
		JPanel locationAll = new JPanel();
		locationAll.setBackground(Color.WHITE);
		JButton[] btnAllLocation = new JButton[allLocation.size()];
		for(int i=0; i<allLocation.size(); i++) {
			btnAllLocation[i] = new JButton(allLocation.get(i));
			btnAllLocation[i].setBackground(Color.WHITE);
			btnAllLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnAllLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(allLocation.get(idx));
					else tfDest.setText(allLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationAll.add(btnAllLocation[i]);
		}
		pnTerminalCards.add("all", locationAll);
		
		JButton btnAll = new JButton("\uC804\uCCB4");
		btnAll.setBackground(Color.WHITE);
		btnAll.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnAll.setBounds(11, 5, 110, 30);
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "all");
				Dimension size = new Dimension(480, 1600);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		panel2.setLayout(null);
		panel2.add(btnAll);
		
		//¼­¿ï Á¤·ùÀå
		JPanel locationSeoul = new JPanel();
		locationSeoul.setBackground(Color.WHITE);
		JButton[] btnSeoulLocation = new JButton[seoulLocation.size()];
		for(int i=0; i<seoulLocation.size(); i++) {
			btnSeoulLocation[i] = new JButton(seoulLocation.get(i));
			btnSeoulLocation[i].setBackground(Color.WHITE);
			btnSeoulLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnSeoulLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(seoulLocation.get(idx));
					else tfDest.setText(seoulLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationSeoul.add(btnSeoulLocation[i]);
		}
		pnTerminalCards.add("seoul", locationSeoul);
		
		JButton btnSeoul = new JButton("\uC11C\uC6B8");
		btnSeoul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "seoul");
				Dimension size = new Dimension(498, 180);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		btnSeoul.setBackground(Color.WHITE);
		btnSeoul.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnSeoul.setBounds(130, 5, 110, 30);
		panel2.add(btnSeoul);
		
		//ÀÎÃµ Á¤·ùÀå
		JPanel locationIncheon = new JPanel();
		locationIncheon.setBackground(Color.WHITE);
		JButton[] btnIncheonLocation = new JButton[incheonLocation.size()];
		for(int i=0; i<incheonLocation.size(); i++) {
			btnIncheonLocation[i] = new JButton(incheonLocation.get(i));
			btnIncheonLocation[i].setBackground(Color.WHITE);
			btnIncheonLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnIncheonLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(incheonLocation.get(idx));
					else tfDest.setText(incheonLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationIncheon.add(btnIncheonLocation[i]);
		}
		pnTerminalCards.add("incheon", locationIncheon);
		
		JButton btnIncheon = new JButton("\uC778\uCC9C/\uACBD\uAE30");
		btnIncheon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "incheon");
				Dimension size = new Dimension(480, 350);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		btnIncheon.setBackground(Color.WHITE);
		btnIncheon.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnIncheon.setBounds(11, 40, 110, 30);
		panel2.add(btnIncheon);
		
		//°­¿ø Á¤·ùÀå
		JPanel locationKangwon = new JPanel();
		locationKangwon.setBackground(Color.WHITE);
		JButton[] btnKangwonLocation = new JButton[kangwonLocation.size()];
		for(int i=0; i<kangwonLocation.size(); i++) {
			btnKangwonLocation[i] = new JButton(kangwonLocation.get(i));
			btnKangwonLocation[i].setBackground(Color.WHITE);
			btnKangwonLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnKangwonLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(kangwonLocation.get(idx));
					else tfDest.setText(kangwonLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationKangwon.add(btnKangwonLocation[i]);
		}
		pnTerminalCards.add("kangwon", locationKangwon);
		
		JButton btnKangwon = new JButton("\uAC15\uC6D0");
		btnKangwon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "kangwon");
				Dimension size = new Dimension(498, 180);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		btnKangwon.setBackground(Color.WHITE);
		btnKangwon.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnKangwon.setBounds(130, 40, 110, 30);
		panel2.add(btnKangwon);
		
		//´ëÀü Á¤·ùÀå
		JPanel locationDaejeon = new JPanel();
		locationDaejeon.setBackground(Color.WHITE);
		JButton[] btnDaejeonLocation = new JButton[daejeonLocation.size()];
		for(int i=0; i<daejeonLocation.size(); i++) {
			btnDaejeonLocation[i] = new JButton(daejeonLocation.get(i));
			btnDaejeonLocation[i].setBackground(Color.WHITE);
			btnDaejeonLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnDaejeonLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(daejeonLocation.get(idx));
					else tfDest.setText(daejeonLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationDaejeon.add(btnDaejeonLocation[i]);
		}
		pnTerminalCards.add("daejeon", locationDaejeon);
		
		JButton btnDaejeon = new JButton("\uB300\uC804/\uCDA9\uB0A8");
		btnDaejeon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "daejeon");
				Dimension size = new Dimension(480, 420);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		btnDaejeon.setBackground(Color.WHITE);
		btnDaejeon.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnDaejeon.setBounds(11, 75, 110, 30);
		panel2.add(btnDaejeon);
		
		//ÃæºÏ Á¤·ùÀå
		JPanel locationChungbuk = new JPanel();
		locationChungbuk.setBackground(Color.WHITE);
		JButton[] btnChungbukLocation = new JButton[chungbukLocation.size()];
		for(int i=0; i<chungbukLocation.size(); i++) {
			btnChungbukLocation[i] = new JButton(chungbukLocation.get(i));
			btnChungbukLocation[i].setBackground(Color.WHITE);
			btnChungbukLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnChungbukLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(chungbukLocation.get(idx));
					else tfDest.setText(chungbukLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationChungbuk.add(btnChungbukLocation[i]);
		}
		pnTerminalCards.add("chungbuk", locationChungbuk);
		
		JButton btnChungbuk = new JButton("\uCDA9\uBD81");
		btnChungbuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "chungbuk");
				Dimension size = new Dimension(498, 180);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		btnChungbuk.setBackground(Color.WHITE);
		btnChungbuk.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnChungbuk.setBounds(130, 75, 110, 30);
		panel2.add(btnChungbuk);
		
		//±¤ÁÖ Á¤·ùÀå
		JPanel locationGwangju = new JPanel();
		locationGwangju.setBackground(Color.WHITE);
		JButton[] btnGwangjuLocation = new JButton[gwangjuLocation.size()];
		for(int i=0; i<gwangjuLocation.size(); i++) {
			btnGwangjuLocation[i] = new JButton(gwangjuLocation.get(i));
			btnGwangjuLocation[i].setBackground(Color.WHITE);
			btnGwangjuLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnGwangjuLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(gwangjuLocation.get(idx));
					else tfDest.setText(gwangjuLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationGwangju.add(btnGwangjuLocation[i]);
		}
		pnTerminalCards.add("gwangju", locationGwangju);
		
		JButton btnGwangju = new JButton("\uAD11\uC8FC/\uC804\uB0A8");
		btnGwangju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "gwangju");
				Dimension size = new Dimension(480, 280);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		btnGwangju.setBackground(Color.WHITE);
		btnGwangju.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnGwangju.setBounds(130, 110, 110, 30);
		panel2.add(btnGwangju);
		
		//ÀüºÏ Á¤·ùÀå
		JPanel locationJeonbuk = new JPanel();
		locationJeonbuk.setBackground(Color.WHITE);
		JButton[] btnJeonbukLocation = new JButton[jeonbukLocation.size()];
		for(int i=0; i<jeonbukLocation.size(); i++) {
			btnJeonbukLocation[i] = new JButton(jeonbukLocation.get(i));
			btnJeonbukLocation[i].setBackground(Color.WHITE);
			btnJeonbukLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnJeonbukLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(jeonbukLocation.get(idx));
					else tfDest.setText(jeonbukLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationJeonbuk.add(btnJeonbukLocation[i]);
		}
		pnTerminalCards.add("jeonbuk", locationJeonbuk);
		
		JButton btnJeonbuk = new JButton("\uC804\uBD81");
		btnJeonbuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "jeonbuk");
				Dimension size = new Dimension(498, 180);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		btnJeonbuk.setBackground(Color.WHITE);
		btnJeonbuk.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnJeonbuk.setBounds(11, 145, 110, 30);
		panel2.add(btnJeonbuk);
		
		//ºÎ»ê Á¤·ùÀå
		JPanel locationBusan = new JPanel();
		locationBusan.setBackground(Color.WHITE);
		JButton[] btnBusanLocation = new JButton[busanLocation.size()];
		for(int i=0; i<busanLocation.size(); i++) {
			btnBusanLocation[i] = new JButton(busanLocation.get(i));
			btnBusanLocation[i].setBackground(Color.WHITE);
			btnBusanLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnBusanLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(busanLocation.get(idx));
					else tfDest.setText(busanLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
				}
			});
			locationBusan.add(btnBusanLocation[i]);
		}
		pnTerminalCards.add("busan", locationBusan);
		
		JButton btnBusan = new JButton("\uBD80\uC0B0/\uACBD\uB0A8");
		btnBusan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "busan");
				Dimension size = new Dimension(498, 180);
				pnTerminalCards.setPreferredSize(size);
			}
		});
		btnBusan.setBackground(Color.WHITE);
		btnBusan.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnBusan.setBounds(11, 110, 110, 30);
		panel2.add(btnBusan);
		
		//´ë±¸ Á¤·ùÀå
		JPanel locationDaegu = new JPanel();
		locationDaegu.setBackground(Color.WHITE);
		JButton[] btnDaeguLocation = new JButton[daeguLocation.size()];
		for(int i=0; i<daeguLocation.size(); i++) {
			btnDaeguLocation[i] = new JButton(daeguLocation.get(i));
			btnDaeguLocation[i].setBackground(Color.WHITE);
			btnDaeguLocation[i].setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
			btnDaeguLocation[i].addActionListener(new MyListener(i) {
				public void actionPerformed(ActionEvent e) {
					if(pointer == 0) tfOrigin.setText(daeguLocation.get(idx));
					else tfDest.setText(daeguLocation.get(idx));
					pointer = 1;
					tfOrigin.setBackground(Color.LIGHT_GRAY);
					tfDest.setBackground(Color.WHITE);
					Dimension size = new Dimension(480, 210);
					pnTerminalCards.setPreferredSize(size);
				}
			});
			locationDaegu.add(btnDaeguLocation[i]);
		}
		pnTerminalCards.add("daegu", locationDaegu);
		
		JButton btnDaegu = new JButton("\uB300\uAD6C/\uACBD\uBD81");
		btnDaegu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnTerminalCards, "daegu");
			}
		});
		btnDaegu.setBackground(Color.WHITE);
		btnDaegu.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnDaegu.setBounds(130, 145, 110, 30);
		panel2.add(btnDaegu);
		
		//¶óº§µé
		JLabel lblNewLabel = new JLabel("\uCD9C\uBC1C\uC9C0");
		lblNewLabel.setForeground(c);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		lblNewLabel.setBounds(12, 52, 199, 43);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uCC29\uC9C0");
		lblNewLabel_1.setForeground(c);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(409, 55, 80, 40);
		jf.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC8FC\uC694\uCD9C\uBC1C\uC9C0");
		lblNewLabel_2.setForeground(c);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(12, 174, 173, 33);
		jf.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uC9C0\uC5ED\uBCC4 \uD130\uBBF8\uB110");
		lblNewLabel_2_1.setForeground(c);
		lblNewLabel_2_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 24));
		lblNewLabel_2_1.setBounds(12, 307, 173, 45);
		jf.getContentPane().add(lblNewLabel_2_1);
		
		//Á¦¸ñ
		JPanel panel = new JPanel();
		panel.setBackground(c);
		panel.setBounds(0, 0, 800, 50);
		jf.getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uBC1C\uC9C0/\uB3C4\uCC29\uC9C0 \uC120\uD0DD");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 32));
		lblNewLabel_3.setForeground(Color.WHITE);
		panel.add(lblNewLabel_3);

		//È®ÀÎ¹öÆ°
		JButton btnSubmit = new JButton("\uD655\uC778");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//parentPanel.setVisible(true);
				//panel1.setVisible(false);
			}
		});
		btnSubmit.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(368, 503, 110, 30);
		jf.getContentPane().add(btnSubmit);
		
		//Ãë¼Ò¹öÆ°
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//panel1.setVisible(false);
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(566, 503, 110, 30);
		jf.getContentPane().add(btnCancel);
		jf.setVisible(true);
	}
	
	public static void setTerminalArray() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3366/buslocation";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String query = "select * from terminallocation";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			allLocation.add(rs.getString("terminal"));
			switch(rs.getString("area")) {
			case "¼­¿ï": seoulLocation.add(rs.getString("terminal")); break;
			case "ÀÎÃµ/°æ±â": incheonLocation.add(rs.getString("terminal")); break;
			case "°­¿ø": kangwonLocation.add(rs.getString("terminal")); break;
			case "´ëÀü/Ãæ³²": daejeonLocation.add(rs.getString("terminal")); break;
			case "ÃæºÏ": chungbukLocation.add(rs.getString("terminal")); break;
			case "ºÎ»ê/°æ³²": busanLocation.add(rs.getString("terminal")); break;
			case "±¤ÁÖ/Àü³²": gwangjuLocation.add(rs.getString("terminal")); break;
			case "ÀüºÏ": jeonbukLocation.add(rs.getString("terminal")); break;
			case "´ë±¸/°æºÏ": daeguLocation.add(rs.getString("terminal")); break;
			}
		}
		Collections.sort(allLocation);
	}
	
	public static void main(String[] args) throws Exception {
		Location a = new Location(new JPanel());
	}
}
