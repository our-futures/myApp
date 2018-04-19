package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.MenuDao;
import com.entity.Menu;


@Repository
@Transactional
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Menu> find() {
		String hql = "from Menu order by menuid ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Menu> list = query.list();
		return list;
		
	}

	@SuppressWarnings("unchecked")
	public List<Menu> findSecond(int level, String menuid) {
		String hql = "from Menu m where m.level = "+level+" and m.menuid like '" + menuid+"%'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Menu> list = query.list();
		return list;
	}



}
