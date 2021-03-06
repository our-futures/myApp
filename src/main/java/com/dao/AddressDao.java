package com.dao;

import java.util.List;
import com.entity.Address;

public interface AddressDao {
	/**
	 * 根据用户id查询收获地址
	 */
	public List<Address> getAddress(int userid);
	/**
	 *保存或修改数据 
	 */
	public void saveOrUpdate(Address address);
	/**
	 * 删除一条数据
	 */
	public void delete(Address address);
	
	/**
	 * 获取一条收货地址
	 */
	public Address getOne(int id);
}
