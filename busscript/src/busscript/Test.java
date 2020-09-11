package busscript;

import javax.swing.*;

public class Test {
	
	static public class Frame1 extends JFrame {
	    private int balance = 0;
	    private JLabel balanceLabel = new JLabel(String.valueOf(balance));
	    private Frame2 childWindow;
	    public Frame1() {
	        JPanel panel = new JPanel();
	        panel.add(new JLabel("Balance:"));
	        panel.add(balanceLabel);
	        JButton balanceButton = new JButton("Balance");
	        balanceButton.addActionListener(e -> {
	            childWindow.setVisible(true);
	            setVisible(false);
	        });
	        panel.add(balanceButton);
	        getContentPane().add(panel);
	        pack();
	        setVisible(true);
	    }
	    void setChildWindow(Frame2 childWindow) {
	        this.childWindow = childWindow;
	    }
	    void addBalance(int balance) {
	        this.balance+=balance;
	        balanceLabel.setText(String.valueOf(this.balance));
	    }
	 }
	
	static public class Frame2 extends JFrame {
	    private Frame1 parentWindow;
	    public Frame2() {
	        JComboBox<Integer> comboBox = new JComboBox<>(new Integer[] {1,2,3,4,5,6,7,8,9});
	        JButton addButton = new JButton("add");
	        addButton.addActionListener(e -> {
	            parentWindow.addBalance((Integer)comboBox.getSelectedItem());
	            parentWindow.setVisible(true);
	            setVisible(false);
	        });
	        JPanel panel = new JPanel();
	        panel.add(comboBox);
	        panel.add(addButton);
	        getContentPane().add(panel);
	        pack();
	    }
	    void setParentWindow(Frame1 parentWindow) {
	        this.parentWindow = parentWindow;
	    }
	}
	
	public static void main(String[] args) {
        Frame1 frame1 = new Frame1();
        Frame2 frame2 = new Frame2();
        frame1.setChildWindow(frame2);
        frame2.setParentWindow(frame1);
	}
}
