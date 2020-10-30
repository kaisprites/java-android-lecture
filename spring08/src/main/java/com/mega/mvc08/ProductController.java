package com.mega.mvc08;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@Autowired
	ProductService service;

	@RequestMapping("create.do")
	public void create(ProductVO vo) {
		int result = service.create(vo);
		System.out.println(result);
	}

	@RequestMapping("one.do")
	public void one(ProductVO vo, Model model) {
		ProductVO vo2 = service.one(vo);
		model.addAttribute("vo2", vo2);
	}

	@RequestMapping("list.do")
	public void list(Model model) {
		List<ProductVO> bag = service.list();
		model.addAttribute("bag", bag);
	}

	@RequestMapping("update.do")
	public void update(ProductVO vo) {
		service.update(vo);
	}

	@RequestMapping("delete.do")
	public void delete(ProductVO vo) {
		service.delete(vo);
	}

}
