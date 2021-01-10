package com.mega.mvc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@RequestMapping("insert.do")
	public void insert (MemberVO vo, Model model) {
		service.insert(vo);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("update.do")
	public void update (MemberVO vo) {
		service.update(vo);
	}
	
	@RequestMapping("delete.do")
	public void delete (MemberVO vo) {
		service.delete(vo);
	}
}
