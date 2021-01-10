package com.mega.test5;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	public List<ProjectDTO> readAll() {
		return mybatis.selectList("readAll");
	}

	public void create(ProjectDTO dto) {
		mybatis.insert("insertOne", dto);
	}
}
