package com.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CardDao;
import com.entity.Card;

@Repository
@Transactional
public class CardDaoImpl implements CardDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Card> getCard(int userid) {
		String hql = "from Card where userid = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userid);
		if(query != null){
			return query.list();
		}
		return null;
	}

	public void save(Card card) {
		card.setAddtime(new Date());
		sessionFactory.getCurrentSession().save(card);

	}

	public void delete(Card card) {
		sessionFactory.getCurrentSession().delete(card);

	}

	@SuppressWarnings("unchecked")
	public Card getOne(int id) {
		Card card = null;
		String hql = "from Card c where c.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<Card> list = query.list();
		if(list.size()>0){
			card = list.get(0);
		}
		return card;
	}

	@SuppressWarnings("unchecked")
	public Card queryBybankid(String bankid) {
		Card card = null;
		String hql = "from Card c where c.banknumber = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, bankid);
		List<Card> list = query.list();
		if(list.size()>0){
			card = list.get(0);
		}
		return card;
	}

}
