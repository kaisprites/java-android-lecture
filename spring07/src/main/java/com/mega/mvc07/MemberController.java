package com.mega.mvc07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping("create2.do")
	public int create2(MemberVO vo) {
		return service.create(vo);
	}
	
	@RequestMapping("delete2.do")
	public int delete2(MemberVO vo) {
		return service.delete(vo);
	}
	
	@RequestMapping("update2.do")
	public int update2(MemberVO vo) {
		return service.update(vo);
	}
	
	@RequestMapping("one2.do")
	public void one2(MemberVO vo, Model model) {
		MemberVO vo2 = service.one(vo);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("list2.do")
	public void list2() {
		List<MemberVO> list = service.list();
	}
}
