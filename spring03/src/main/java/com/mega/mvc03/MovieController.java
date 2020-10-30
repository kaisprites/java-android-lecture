package com.mega.mvc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mega.mvc03.movie.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService movieService;

	@RequestMapping(value="movie", produces="text/plain;charset=UTF-8")
	public String movie(String title, String price, Model model) {
		price = String.valueOf(movieService.priceSale(Integer.parseInt(price)));
		model.addAttribute("title", title);
		model.addAttribute("price", price);
		return "like";
	}
	
	@RequestMapping(value="reply")
	public String reply(String reply, String history, Model model) {
		model.addAttribute("replyValue", reply);
		model.addAttribute("replyHistory", history);
		return "reply";
	}
	
	@RequestMapping(value="idcheck")
	public String idCheck(String id, Model model) {
		String result = movieService.idcheck(id);
		model.addAttribute("result", result);
		if(result.equals("id를 사용할 수 있습니다.")) return "idcheck-correct";
		return "idcheck";
	}
}
