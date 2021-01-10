package com.mega.test5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	@Autowired
	ProjectDAO dao;
	
	public List<ProjectDTO> readAll() {
		return dao.readAll();
	}

	public void create(ProjectDTO dto) {
		dao.create(dto);
		
	}
}
