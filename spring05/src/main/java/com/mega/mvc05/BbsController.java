package com.mega.mvc05;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BbsController {
	/* method 입력값으로 vo를 설정하는 경우 
	 * 1: 객체생성 prototype
	 * 2: input name 속성과 동일한 set method 자동 호출
	 * 3: 변수이름을 클래스이름의 camelcase로 지정한 경우 자동으로 vo를 model속성으로 지정 
	 *	  뷰 jsp파일에서 model속성값을 사용할 수 있다.
	 *
	 *  model은 한번의 request 당 response 하고 사라진다
	 *  여러번의 request 마다 특정한 값 유지하려면 session 설정할 필요 있다
	 */
	
	@Autowired
	BbsService service;
	
	@RequestMapping("insert.do")
	public void insert(BbsVO bbsVO, HttpSession session) {
		service.insert(bbsVO);
		session.setAttribute("bbsvoSession", bbsVO);
	}
	
	@RequestMapping("update.do")
	public void update(Model model) {
		//db 검색해서 가져온 결과를 views에 있는 update.jsp에 넘긴다
		model.addAttribute("result", "검색결과");
	}
	@RequestMapping("delete.do")
	public void delete(Model model) {
		//임의의 db처리
	}
}
