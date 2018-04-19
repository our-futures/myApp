package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BrandDao;
import com.entity.Brand;

@Repository
@Transactional
public class BrandDaoImpl implements BrandDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Brand> findBrand(String menuid) {
		String hql = "from Brand b where b.menuId like '" + menuid+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Brand> list = query.list();
		return list;
	}

}
