package com.mega.test5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService service;
	
	//index redirector
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index(Model model) {
		List<ProjectDTO> list = service.readAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	//create
	@RequestMapping(value = "create", method=RequestMethod.POST)
	public String create (ProjectDTO dto, Model model) {
		service.create(dto);
		return "redirect:index";
	}
}
