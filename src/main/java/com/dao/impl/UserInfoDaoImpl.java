package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserInfoDao;
import com.entity.UserInfo;

@Repository
@Transactional
public class UserInfoDaoImpl implements UserInfoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public UserInfo getUserInfo(int userid) {
		UserInfo info = null;
		String hql = "from UserInfo u where u.userid = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userid);
		List<UserInfo> list = query.list();
		if(list.size()>0){
			info = list.get(0);
		}
		return info;
		
	}



	public void save(UserInfo userInfo) {
		sessionFactory.getCurrentSession().save(userInfo);

	}



	public void update(UserInfo userInfo) {
		sessionFactory.getCurrentSession().update(userInfo);	
	}



	public void saveOrUpdate(UserInfo userInfo) {
		sessionFactory.getCurrentSession().saveOrUpdate(userInfo);	
	}



	public UserInfo findById(int userid) {
		String hql = "from UserInfo where userid = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<UserInfo> list = query.list();
		if(list.size() >0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
