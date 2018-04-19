package com.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.QuestionDao;
import com.entity.Question;


@Repository
@Transactional
public class QuestionDaoImpl implements QuestionDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Question> query() {
		String hql = " from Question ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(query != null){
			return query.list();
		}
		return null;
	}

	public void add(Question question) {
		question.setAddtime(new Date());
		sessionFactory.getCurrentSession().save(question);

	}

}
