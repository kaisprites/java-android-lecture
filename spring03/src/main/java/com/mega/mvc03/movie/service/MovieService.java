package com.mega.mvc03.movie.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	MemberDAO dao;
	
	public int priceSale(int x) {
		if (x >= 10000) x = x * 9 / 10;
		//dao.create(price)
		return x * 9 / 10;
	}
	
	public String idcheck (String id) {
		String result = "id를 사용할 수 있습니다.";
	
		if(id.length() < 4) {
			result = "id의 길이가 유효하지 않습니다.";
		}
		String[] idlist = {"root", "admin", "apple", "melon", "mint"};
		List<String> list = Arrays.asList(idlist);
		if(list.contains(id)) {
			result = "id가 중복입니다.";
		}
		return result;
	}
}
