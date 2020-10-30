package com.mega.mvc08;

import java.util.List;

public interface ProductCRUD {
	int create(ProductVO vo);
	ProductVO one(ProductVO vo);
	List<ProductVO> list();
	int update(ProductVO vo);
	int delete(ProductVO vo);
}
