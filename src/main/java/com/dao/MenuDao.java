package com.dao;

import java.util.List;

import com.entity.Menu;

public interface MenuDao {
	
	/**
	 * 查等级菜单
	 */
	public List<Menu> find() ;
	/**
	 * 查二级菜单
	 */
	public List<Menu> findSecond(int level,String menuid) ;
	

}
