package com.dao;

import com.entity.Answer;


public interface AnswerDao {
	/**
	 * 根据用户id查询所有安全问题
	 */
	public Answer getAnswer(int userid);
	/**
	 * 添加安全问题
	 */
	public void saveorupdate(Answer answer);
	
}
