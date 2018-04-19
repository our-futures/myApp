package com.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserInfoDao;
import com.entity.UserInfo;
import com.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Resource
	UserInfoDao userInfoDao;

	public UserInfo getUserInfo(int userid) {
		return userInfoDao.getUserInfo(userid);
	}

	public void update(UserInfo userInfo) {
		// TODO Auto-generated method stub

	}

	public void save(UserInfo userInfo) {
		// TODO Auto-generated method stub

	}

	public void saveOrUpdate(UserInfo userInfo) {
		userInfo.setChangetime(new Date());
		userInfoDao.saveOrUpdate(userInfo);
		
	}

	public UserInfo findById(int userid) {
		return userInfoDao.findById(userid);
	}

}
