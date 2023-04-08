package com.ty.hospital_app.dao.impl;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.MedOrderDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.MedOrder;

public class MedOrderDaoImpl implements MedOrderDao
{

	public MedOrder saveMedOrder(int eid, MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null)
		{
			entityTransaction.begin();
			entityManager.persist(medOrder);
			entityTransaction.commit();
			return medOrder;
		}
		else
		{
			return null;
		}

	}

	public MedOrder getMedOrderById(int mid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		MedOrder medOrder=entityManager.find(MedOrder.class, mid);
		return medOrder;
	}

	public boolean deleteMedOrderById(int mid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		MedOrder medOrder=entityManager.find(MedOrder.class, mid);
		if(medOrder!=null)
		{
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			return true;
		}
		else
		{
			return false;
		}

	}

	public MedOrder updateMedOrderById(int mid, MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction  entityTransaction=entityManager.getTransaction();
		MedOrder medOrder1=entityManager.find(MedOrder.class, mid);
		if(medOrder1!=null)
		{
			medOrder.setDname(medOrder1.getDname());
			medOrder.setOrderDate(medOrder1.getOrderDate());
			entityTransaction.begin();
			entityManager.merge(medOrder);
			entityTransaction.commit();
			return medOrder;
		}
		else
		{
			return null;
		}
	}

	public List<MedOrder> getAllMedOrder() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select m from MedOrder m");
		List<MedOrder> medOrder=query.getResultList();
		return medOrder;
	}

	public List<MedOrder> getAllMedOrderByDoctorName(String dname) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select m from MedOrder m where dname=?0");
		query.setParameter(0, dname);
		List<MedOrder> medOrder=query.getResultList();

		return medOrder;
	}

	public List<MedOrder> getAllMedOrderByDate(String date) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select m from MedOrder m where orderDate=?0");
		query.setParameter(0, date);
		List<MedOrder> medOrder=query.getResultList();

		return medOrder;
	}

}
