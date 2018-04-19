package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ChinaDao;
import com.entity.China;

@Repository
@Transactional
public class ChinaDaoImpl implements ChinaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<China> findProvince() {
		String hql = "from China where pid = 0";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(query != null){
			return query.list();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<China> findCity(int pid) {
		String hql = "from China where pid = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, pid);
		if(query != null){
			return query.list();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<China> findArea(int pid) {
		String hql = "from China where pid = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, pid);
		if(query != null){
			return query.list();
		}
		return null;
	}

}
