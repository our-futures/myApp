package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ChinaDao;
import com.entity.China;
import com.service.ChinaService;

@Service
public class ChinaServiceImpl implements ChinaService {

	@Resource
	ChinaDao chinaDao;
	
	public List<China> findProvince() {
		return chinaDao.findProvince();
	}

	public List<China> findCity(int pid) {
		return chinaDao.findCity(pid);
	}

	public List<China> findArea(int pid) {
		return chinaDao.findArea(pid);
	}

}
