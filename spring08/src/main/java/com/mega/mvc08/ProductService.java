package com.mega.mvc08;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService implements ProductCRUD {
	
	@Autowired
	ProductDAO dao;

	@Override
	public int create(ProductVO vo) {
		int result = dao.create(vo);
		System.out.println(result);
		return result;
	}

	@Override
	public ProductVO one(ProductVO vo) {
		return dao.one(vo);
	}

	@Override
	public List<ProductVO> list() {
		return dao.list();
	}

	@Override
	public int update(ProductVO vo) {
		return dao.update(vo);
	}

	@Override
	public int delete(ProductVO vo) {
		return dao.delete(vo);
	}

}
