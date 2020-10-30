package com.mega.mvc07;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Bean
//@Component (component == bean) 부모클래스
@Repository
public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public int insert(MemberVO vo) {
		int result = mybatis.insert("member.create", vo);
		return result;
	}
	
	public int update(MemberVO vo) {
		int result = mybatis.update("member.update", vo);
		return result;
	}
	
	public int delete(MemberVO vo) {
		return mybatis.delete("member.delete", vo);
	}
	
	public MemberVO one(MemberVO vo) {
		MemberVO vo2 = mybatis.selectOne("member.one", vo);
		return vo2;
	}
	
	public List<MemberVO> list() {
		return mybatis.selectList("member.list");
	}
}
