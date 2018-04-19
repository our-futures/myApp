package com.dao;

import java.util.List;

import com.entity.Brand;


public interface BrandDao {
	/**
	 * 根据菜单id查询相对应的品牌
	 */
	public List<Brand> findBrand(String menuid) ;

}
