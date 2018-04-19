package com.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AnswerDao;
import com.entity.Answer;

@Repository
@Transactional
public class AnswerDaoImpl implements AnswerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public Answer getAnswer(int userid) {
		Answer  answer = null;
		String hql = "from Answer where userid = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userid);
		List<Answer> list = query.list();
		if(list.size() > 0){
			answer = list.get(0);
		}
		return answer;
	}

	public void saveorupdate(Answer answer) {
		answer.setChangetime(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(answer);

	}

}
