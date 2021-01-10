package com.mega.mvc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	MemberDAO dao;
	
	public void insert(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.insert(vo);
	}

	public void update(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	public void delete(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}

}
