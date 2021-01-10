package com.mega.mvc01;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insert (MemberVO vo) {
		mybatis.insert("insert", vo);
	}

	public void update(MemberVO vo) {
		mybatis.update("update", vo);
	}

	public void delete(MemberVO vo) {
		// TODO Auto-generated method stub
		mybatis.delete("delete", vo);
	}
}
