package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QuestionDao;
import com.entity.Question;
import com.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Resource
	QuestionDao questionDao;
	
	public List<Question> query() {
		return questionDao.query();
	}

	public void add(Question question) {
		questionDao.add(question);

	}

}
