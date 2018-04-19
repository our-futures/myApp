package com.service;

import com.entity.UserInfo;

public interface UserInfoService {
	
	/**
	 * 根据用户id查询用户信息资料
	 */
	public UserInfo getUserInfo(int userid);
	
	/**
	 * 修改用户数据
	 */
	public void update(UserInfo userInfo);
	
	/**
	 * 保存用户数据
	 *
	 */
	public void save(UserInfo userInfo);
	
	/**
	 * 保存或修改数据
	 */
	public void saveOrUpdate(UserInfo userInfo);
	/**
	 * 根据userid查找一条用户信息
	 */
	public UserInfo findById(int userid);
}
