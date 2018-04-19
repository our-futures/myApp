package com.dao;

import com.entity.User;

public interface UserDao {
	
	/**
	 * 根据用户名和密码查找用户
	 */
	public User findByNameAndPwd(String name,String pwd);
	/**
	 * 根据邮箱和密码查找用户
	 */
	public User findByEmailAndPwd(String name,String pwd);
	/**
	 * 根据手机和密码查找用户
	 */
	public User findByPhoneAndPwd(String name,String pwd);
	/**
	 * 根据用户名查找用户
	 */
	public User findByName(String name);
	/**
	 * 根据邮箱查询用户类型
	 */
	public User findByEmail(String email);
	
	/**
	 * 根据手机查询用户类型
	 */
	public User findByPhone(String phone) ;
	/**
	 * 添加一个用户
	 */
	public void add(User user);
	/**
	 * 修改登录信息
	 */
	public void updateUser(String hql , Object...parms);
	/**
	 * 更新登录信息
	 */
	public void update(User user);
	/**
	 * 根据id查找一条用户信息
	 */
	public User findById(int id);
}
