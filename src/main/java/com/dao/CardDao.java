package com.dao;

import java.util.List;

import com.entity.Card;


public interface CardDao {
	
	/**
	 * 根据用户id查询所有银行卡
	 */
	public List<Card> getCard(int userid);
	/**
	 * 根据银行卡号查询
	 */
	public Card queryBybankid(String bankid);
	/**
	 *添加一张银行卡
	 */
	public void save(Card card);
	/**
	 * 删除一条数据
	 */
	public void delete(Card card);
	
	/**
	 * 获取一张银行卡数据
	 */
	public Card getOne(int id);
	
}
