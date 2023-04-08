package com.ty.hospital_app.dao.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.AddressDao;
import com.ty.hospital_app.dto.Address;
import com.ty.hospital_app.dto.Branch;

public class AddressDaoImpl implements AddressDao
{

	public Address saveAddress(int bid, Address address) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, bid);
		if(branch!=null)
		{
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
			return address;
		}
		else
		{
			return null;
		}

	}

	public Address getAddressById(int aid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Address address=entityManager.find(Address.class, aid);
		return address;
	}

	public boolean deleteAddressById(int aid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Address address=entityManager.find(Address.class, aid);
		if(address!=null)
		{
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}

	}

	public Address updateAddressById(int aid, Address address) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Address address1=entityManager.find(Address.class, aid);
		
		if(address1!=null)
		{
			address.setStreet(address1.getStreet());
			address.setState(address1.getState());
			address.setCountry(address1.getCountry());
			entityTransaction.begin();
			entityManager.merge(address);
			entityTransaction.commit();
			return address;
		}
		else
		{
			return null;
		}
	}

	public List<Address> getAllAddress() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select a from Address a");
		List<Address> address=query.getResultList();
		return address;
	}

}
