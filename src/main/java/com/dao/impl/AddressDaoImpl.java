package com.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AddressDao;
import com.entity.Address;


@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Address> getAddress(int userid) {
		String hql = "from Address where userid = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userid);
		if(query != null){
			return query.list();
		}
		return null;
	}

	public void saveOrUpdate(Address address) {
		address.setOperatetime(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(address);	

	}

	public void delete(Address address) {
		sessionFactory.getCurrentSession().delete(address);

	}

	@SuppressWarnings("unchecked")
	public Address getOne(int id) {
		Address address = null;
		String hql = "from Address a where a.id = ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		List<Address> list = query.list();
		if(list.size()>0){
			address = list.get(0);
		}
		return address;
	}

}
