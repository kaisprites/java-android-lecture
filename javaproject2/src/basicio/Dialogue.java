package basicio;

import javax.swing.JOptionPane;

public class Dialogue {

	public static void main(String[] args) {
		//Java의 코딩방식: 특정한 일을 처리하는 부품을 만들어 전담 (메소드)
		//Java에서 자주 사용되는 클래스는 미리 메모리에 저장되어 있다.
		
		String hour = JOptionPane.showInputDialog("지금 몇시인가요?");
		JOptionPane.showMessageDialog(null, hour+"시입니다.");
		
		//empty == null
		//기능을 처리해주는 단위: function(함수)
		
		//int <- String
		int hour2 = Integer.parseInt(hour);
		
		if (hour2 < 16) { //조건에는 비교연산자를 사용, 비교연산자의 결과는 boolean
			//true
			JOptionPane.showMessageDialog(null, "집에 갈 시간이 멀었다.");
		} else {
			//false
			JOptionPane.showMessageDialog(null, "집에 갈 시간이 얼마 남지 않았다.");
		}
	}

}
