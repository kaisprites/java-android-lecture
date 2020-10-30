package com.mega.mvc05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	

	
	public void create (MemberVO vo) {
		memberDAO.insert(vo);
	}
}
