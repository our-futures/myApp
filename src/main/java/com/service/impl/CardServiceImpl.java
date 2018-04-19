package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CardDao;
import com.entity.Card;
import com.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	@Resource 
	CardDao cardDao;
	
	
	public List<Card> getCard(int userid) {
		return cardDao.getCard(userid);
	}

	public void save(Card card) {
		cardDao.save(card);

	}

	public void delete(Card card) {
		cardDao.delete(card);

	}

	public Card getOne(int id) {
		return cardDao.getOne(id);
	}

	public Card queryBybankid(String bankid) {
		return cardDao.queryBybankid(bankid);
	}

}
