package com.mega.mv02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("insert.do")
	public void insert(String id, String pw, String re) {
		String result = "����";
		if(id.length() <= 5) {
			System.out.println("��ȿ�� ���� id");
			result = "����";
		}
		if(!pw.equals(re)) {
			System.out.println("��й�ȣ �߸� �Է�");
			result = "����";
		}
		
	}
}
