package com.mega.mvc07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO dao;
	
	public int create(MemberVO vo) {
		return dao.insert(vo);
	}
	
	public int delete(MemberVO vo) {
		return dao.delete(vo);
	}
	
	public int update(MemberVO vo) {
		return dao.update(vo);
	}
	
	public MemberVO one(MemberVO vo) {
		return dao.one(vo);
	}
	
	public List<MemberVO> list() {
		return dao.list();
	}
}
