package com.dao;

import java.util.List;

import com.entity.China;

public interface ChinaDao {
	/**
	 * 查询所有省份
	 */
	public List<China> findProvince();
	/**
	 * 根据省份查询城市
	 */
	public List<China> findCity(int pid);
	/**
	 * 根据城市查询区县
	 */
	public List<China> findArea(int pid);
}
