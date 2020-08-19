package branch;

import javax.swing.JOptionPane;

public class ConditionQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력이 '아이스크림'이면 '뚜레주르로 가요' 출력
		//입력이 '아이스커피'이면 '이디야로 가요' 출력
		//둘 다 아니면 '물마셔요' 출력
		String food = JOptionPane.showInputDialog("먹고 싶은 음식:");
		String result = "";
		if(food.equals("아이스크림")) result = "뚜레주르로 가요";
		else if(food.equals("아이스커피")) result = "이디야로 가요";
		else result = "물마셔요";
		
		System.out.println(result);
	}

}
