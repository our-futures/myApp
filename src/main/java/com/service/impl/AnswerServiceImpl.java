package com.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AnswerDao;
import com.entity.Answer;
import com.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	
	@Resource
	AnswerDao answerDao;
	public Answer getAnswer(int userid) {
		return answerDao.getAnswer(userid);
	}

	public void save(Answer answer) {
		answerDao.saveorupdate(answer);

	}

}
