package com.mega.mvc05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsService {
	
	@Autowired
	BbsDAO bbsDAO;
	
	//전역변수의 주소와 값넣는방법: parametered constructor, set method
//	
//	public BbsService(BbsDAO dao) {
//		this.bbsDAO = dao;
//	}
	
	public void setBbsDAO(BbsDAO dao) {
		this.bbsDAO = dao;
	}
	
	public void insert (BbsVO vo) {
		bbsDAO.insert(vo);
	}
}
