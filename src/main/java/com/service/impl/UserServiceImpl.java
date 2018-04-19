package com.service.impl;

import static com.utils.GetIp.getIpAddr;

import java.awt.RenderingHints.Key;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import com.utils.KeyType;
import com.utils.VaildType;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	UserDao userDao;

	public User login(String name, String pwd) {
		User userInfo = null;
		if(!"".equals(name.trim()) && !"".equals(pwd.trim())){
			int result = VaildType.checkUserType(name);
			switch(result){
//			   case KeyType.KEY_ONE:
//				   userInfo = userDao.findByNameAndPwd(name, pwd);
//				   break;
			   case KeyType.KEY_TWO:
				   userInfo = userDao.findByEmailAndPwd(name,pwd);
				   break;
			   case KeyType.KEY_THREE:
				   userInfo = userDao.findByPhoneAndPwd(name,pwd);
				   break;
			   default:
//				   userInfo = userDao.findByNameAndPwd(name,pwd);
				   break;
			}
		}
		if(userInfo != null){
			String loginip  = getIpAddr();
			userInfo.setLastlogintime(new Date());
			userInfo.setLoginip(loginip);
			userDao.update(userInfo);
		}
		return userInfo;
	}
	

	public User findUser(String name){
		User userInfo = null;
		if(!"".equals(name)){
			int result = VaildType.checkUserType(name);
			switch(result){
//			   case 1:  //不做用户名校验
//				   userInfo = userDao.findByName(name);
//				   break;
			   case KeyType.KEY_TWO:
				   userInfo = userDao.findByEmail(name);
				   break;
			   case KeyType.KEY_THREE:
				   userInfo = userDao.findByPhone(name);
				   break;
			   default:
//				   userInfo = userDao.findByName(name);
				   break;
			}
		}
		return userInfo;
	}

	public void add(String name,String parm, String pwd) {
		User user = new User();
		String ip  = getIpAddr();
		user.setPwd(pwd);
		user.setRegistertime(new Date());
		user.setRegisterip(ip);
		user.setName(name);
		int result = VaildType.checkUserType(parm);
		switch(result){
//		   case 1:
//			   user.setName(parm);
//			   userDao.add(user);
//			   break;
		   case KeyType.KEY_TWO:
			   user.setEmail(parm);
			   userDao.add(user);
			   break;
		   case KeyType.KEY_THREE:
			   user.setPhone(parm);
			   userDao.add(user);
			   break;
		   default:
//			   user.setName(parm);
//			   userDao.add(user);
			   break;
		}
	}


	public void update(User user) {
		user.setLastchangetime(new Date());
		userDao.update(user);
		
	}


	public User findById(int id) {
		return userDao.findById(id);
	}}
