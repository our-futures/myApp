package com.dao;

import java.util.List;

import com.entity.Question;


public interface QuestionDao {
	/**
	 * 查询所有问题
	 */
	public List<Question> query();
	/**
	 * 添加一个问题
	 */
	public void add(Question question);
}
