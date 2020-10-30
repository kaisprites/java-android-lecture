package com.mega.mvc03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//일반 java 파일: POJO (plain old java object)	
//Controller 기능을 가진 클래스로 만들고 싶으면 상속
//@Controller anotation 사용하면
//	1) 상속
//	2) HandlerMapper에 key:value 등록, 요청되는 주소:객체 메서드
//

@Controller
public class CarController {
	
	//컨트롤러에서 뷰까지 넘어가기 위한 항목:
	// 뷰페이지 지정, model 속성값
	// Spring5 이후부터는 model과 view를 따로 넘겼습니다.
	@RequestMapping("car")
	public String car(String color, Model model) {
		System.out.println("컨트롤러에서 받은 색은 " + color);
		model.addAttribute("color", color);
		return "img";
	}
}
