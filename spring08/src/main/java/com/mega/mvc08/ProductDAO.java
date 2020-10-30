package com.mega.mvc08;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO implements ProductCRUD {
	
	@Autowired
	SqlSessionTemplate mybatis;

	@Override
	public int create(ProductVO vo) {
		int result = mybatis.insert("product.create", vo);
		System.out.println(result);
		return result;
	}

	@Override
	public ProductVO one(ProductVO vo) {
		return mybatis.selectOne("product.one", vo);
	}

	@Override
	public List<ProductVO> list() {
		return mybatis.selectList("product.list");
	}

	@Override
	public int update(ProductVO vo) {
		return mybatis.update("product.update", vo);
	}

	@Override
	public int delete(ProductVO vo) {
		return mybatis.delete("product.delete", vo);
	}

}
