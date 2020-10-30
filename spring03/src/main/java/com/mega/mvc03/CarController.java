package com.mega.mvc03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//�Ϲ� java ����: POJO (plain old java object)	
//Controller ����� ���� Ŭ������ ����� ������ ���
//@Controller anotation ����ϸ�
//	1) ���
//	2) HandlerMapper�� key:value ���, ��û�Ǵ� �ּ�:��ü �޼���
//

@Controller
public class CarController {
	
	//��Ʈ�ѷ����� ����� �Ѿ�� ���� �׸�:
	// �������� ����, model �Ӽ���
	// Spring5 ���ĺ��ʹ� model�� view�� ���� �Ѱ���ϴ�.
	@RequestMapping("car")
	public String car(String color, Model model) {
		System.out.println("��Ʈ�ѷ����� ���� ���� " + color);
		model.addAttribute("color", color);
		return "img";
	}
}
