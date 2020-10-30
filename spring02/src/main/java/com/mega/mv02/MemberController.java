package com.mega.mv02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("insert.do")
	public void insert(String id, String pw, String re) {
		String result = "성공";
		if(id.length() <= 5) {
			System.out.println("유효하 않은 id");
			result = "실패";
		}
		if(!pw.equals(re)) {
			System.out.println("비밀번호 잘못 입력");
			result = "실패";
		}
		
	}
}
