package com.service.impl;

import static com.utils.GetIp.getIpAddr;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.AddressDao;
import com.entity.Address;
import com.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Resource
	AddressDao addressDao;
	
	public List<Address> getAddress(int userid) {
		return addressDao.getAddress(userid);
	}

	public void saveOrUpdate(Address address) {
		String operateip  = getIpAddr();
		address.setOperateip(operateip);
		addressDao.saveOrUpdate(address);
	}

	public void delete(int id) {
		Address address = addressDao.getOne(id);
		addressDao.delete(address);
		
	}

	public Address getOne(int id) {
		return addressDao.getOne(id);
	}

}
