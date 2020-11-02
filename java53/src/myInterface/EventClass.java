package myInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventClass implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("첫번째 버튼 누름");
	}

}
