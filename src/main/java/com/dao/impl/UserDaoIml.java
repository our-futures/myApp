package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dao.UserDao;
import com.entity.User;


@Repository
@Transactional
public class UserDaoIml implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 根据用户号或用户手机号
	 */

	@SuppressWarnings("unchecked")
	public User findByNameAndPwd(String name, String pwd) {
		User user = null;
		String hql = "from User where name = ? and pwd = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, pwd);
		List<User> list = query.list();
		if(list.size() > 0){
			user = list.get(0);
		}
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public User findByEmailAndPwd(String name, String pwd) {
		User user = null;
		String hql = "from User where email = ? and pwd = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, pwd);
		List<User> list = query.list();
		if(list.size() > 0){
			user = list.get(0);
		}
		return user;
	}


	@SuppressWarnings("unchecked")
	public User findByPhoneAndPwd(String name, String pwd) {
		User user = null;
		String hql = "from User where phone = ? and pwd = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, pwd);
		List<User> list = query.list();
		if(list.size() > 0){
			user = list.get(0);
		}
		return user;
	}

	
	@SuppressWarnings("unchecked")
	public User findByName(String name) {
		String hql = "from User where name = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		List<User> list = query.list();
		if(list.size() >0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public User findByEmail(String email) {
		String hql = "from User where email = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, email);
		List<User> list = query.list();
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
		
	}
	@SuppressWarnings("unchecked")
	public User findByPhone(String phone) {
		String hql = "from User where phone = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, phone);
		List<User> list = query.list();
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

	public void add(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	
	public void updateUser(String hql, Object... parms) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(parms != null && parms.length>0){
			for(int i=0; i<parms.length;i++){
				query.setParameter(i, parms[i]);
			}
		}
		query.executeUpdate();
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

	@SuppressWarnings("unchecked")
	public User findById(int id) {
		String hql = "from User where id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<User> list = query.list();
		if(list.size() >0){
			return list.get(0);
		}else{
			return null;
		}
	}

	

	


	

}
