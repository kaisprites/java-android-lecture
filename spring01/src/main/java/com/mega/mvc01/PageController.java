package com.mega.mvc01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	//Controller
	@RequestMapping("page2.mega")
	public void page2 (String id, String pw, Model model) {
	    String result = "�α��ν���";
		if(id.equals("root")&&pw.equals("1234")) {
			result = "�α��μ���";
		}
		model.addAttribute("result", result);
	}
}
